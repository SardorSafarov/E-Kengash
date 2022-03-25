package com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.yangiliklar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.FragmentYangiliklarBinding
import com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.adapter.BildishNomaAdapter
import com.example.network.entity.bildirshnoma.Arr
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewModelFactory.kupBeriladiganSavollar.KupBeriladiganSavollarViewModelFactory
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel


class Yangiliklar : Fragment(),BildishNomaAdapter.onClickListener {
    private var _binding: FragmentYangiliklarBinding? = null
    private val binding get() = _binding!!
    private lateinit var kupBeriladiganSavollarViewModel: KupBeriladiganSavollarViewModel
    private val adapter:BildishNomaAdapter by lazy { BildishNomaAdapter(this,requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYangiliklarBinding.inflate(inflater, container, false)
        val view = binding.root
        setUi()
        return view
    }
    private fun setUi() {
        val kupBeriladiganSavollarRepository = KupBeriladiganSavollarRepository()
        val kupBeriladiganSavollarViewModelFactory =
            KupBeriladiganSavollarViewModelFactory(kupBeriladiganSavollarRepository)
        val kupBeriladiganSavollarViewModel = ViewModelProvider(
            this,
            kupBeriladiganSavollarViewModelFactory
        ).get(KupBeriladiganSavollarViewModel::class.java)
        this.kupBeriladiganSavollarViewModel = kupBeriladiganSavollarViewModel

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        kupBeriladiganSavollarViewModel.bildirishnoma(TOKEN){
            if(it.isSuccessful){
               setDataYangiliklar(it.body()!!.data.arr)
            }
        }
    }

    private fun setDataYangiliklar(arr: List<Arr>) {
            binding.apply {
                yangiliklar.adapter = adapter
                yangiliklar.layoutManager = LinearLayoutManager(requireContext())
                adapter.setData(arr)
            }
    }

    override fun onclickListener(item: Arr) {
        val intent = Intent(requireContext(),YangiliklarFulScreen::class.java)
        intent.putExtra("name",item.name)
        intent.putExtra("image",item.image_link)
        intent.putExtra("title",item.content)
        startActivity(intent)
    }


}