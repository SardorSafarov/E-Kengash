package com.example.servislar.taxi.qidirish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katrip.R
import com.example.katrip.databinding.BottomSheetServesQayerdanBinding
import com.example.katrip.databinding.FragmentTaxiQidirishBinding
import com.example.katrip.fragmentlar.asosiyy.adapter.TakliflarLayfxaklarAdapter
import com.example.log.D
import com.example.network.entity.takliflarLayfxaklar.javob.Arr
import com.example.network.entity.taxi.shaxarQidirsh.Javob.TaxsiShaxarQidirishJavob
import com.example.network.repository.takliflarLayfxaklar.TakliflarLayfxaklarRepisitory
import com.example.network.repository.taxi.TaxiRepository
import com.example.network.viewModelFactory.takliflarLayfxaklar.TakliflarLayfxaklarViewModelFactory
import com.example.network.viewModelFactory.taxi.TaxiViewModelFactory
import com.example.network.viewmodel.takliflarLayfxaklar.TakliflarLayfxaklarViewModel
import com.example.network.viewmodel.taxi.TaxiViewModel
import com.example.room.viewModel.UserViewModel
import com.example.servislar.stories.TakliflarLayfxaklarFullScreen
import com.example.servislar.taxi.adapter.QayerdanQayergaAdapter
import com.example.servislar.taxi.taxiQidirish.HaydovchiQidirish
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class TaxiQidirish : Fragment(), TakliflarLayfxaklarAdapter.onClickListener,
    QayerdanQayergaAdapter.kategoriyaView {
    private var _binding: FragmentTaxiQidirishBinding? = null
    private val binding get() = _binding!!
    private lateinit var takliflarLayfxaklarViewModel: TakliflarLayfxaklarViewModel
    private val takliflarLayfxaklarAdapter: TakliflarLayfxaklarAdapter by lazy {
        TakliflarLayfxaklarAdapter(this,
            applicationContext = requireContext())
    }
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var taxiViewModel: TaxiViewModel
    private lateinit var qayerdanSave: TaxsiShaxarQidirishJavob
    private lateinit var qayergaSave: TaxsiShaxarQidirishJavob
    private lateinit var vaqt:String
    private val qayerdanQayergaAdapter: QayerdanQayergaAdapter by lazy {
        QayerdanQayergaAdapter(this,
            requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTaxiQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        layfxaklarSetUi()
        taxiSetUi()
        return view
    }

    private fun taxiSetUi() {
        val taxiRepisitory = TaxiRepository()
        val taxiViewModelFactory = TaxiViewModelFactory(taxiRepisitory)
        val taxiViewModel = ViewModelProvider(
            this,
            taxiViewModelFactory
        ).get(TaxiViewModel::class.java)
        this.taxiViewModel = taxiViewModel
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        teginma()
        takliflarLayfxaklar()

    }


    private fun layfxaklarSetUi() {
        val takliflarLayfxaklarRepisitory = TakliflarLayfxaklarRepisitory()
        val takliflarLayfxaklarViewModelFactory =
            TakliflarLayfxaklarViewModelFactory(takliflarLayfxaklarRepisitory)
        val takliflarLayfxaklarViewModel = ViewModelProvider(
            this,
            takliflarLayfxaklarViewModelFactory
        ).get(TakliflarLayfxaklarViewModel::class.java)
        this.takliflarLayfxaklarViewModel = takliflarLayfxaklarViewModel

    }

    private fun takliflarLayfxaklar() {
        userViewModel.readUser.observe(requireActivity(), androidx.lifecycle.Observer {

            takliflarLayfxaklarViewModel.takliflarLayfxaklar(it.get(0).token.toString(), "taxi")
            {
                if (it.isSuccessful) {
                    taklifLafxaklarsetAdapterData(it.body()!!.data.arr)
                } else {
                    D.d("TaxiQidirish takliflarLayfxaklar funida")
                }
            }
        })

    }

    private fun taklifLafxaklarsetAdapterData(arr: List<Arr>) {
        binding.apply {
            takliflarLayfhaklarRecyc.adapter = takliflarLayfxaklarAdapter
            takliflarLayfhaklarRecyc.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false)
            takliflarLayfxaklarAdapter.setData(arr)
        }

    }

    override fun onClickListener(item: Arr) {
        val intent = Intent(requireContext(), TakliflarLayfxaklarFullScreen::class.java)
        intent.putExtra("text1", item.content1)
        intent.putExtra("text2", item.content2)
        intent.putExtra("text3", item.content3)
        intent.putExtra("name", item.name)
        intent.putExtra("image", item.image_link)
        startActivity(intent)
    }


    private fun teginma() {
        taxiQayerdan()
        taxiQayerga()
        taxiQachon()
        taxiIzlash()
    }

    private fun taxiIzlash() {
        binding.taxiIzlash.setOnClickListener {
            try {
                var intent = Intent(requireActivity(),HaydovchiQidirish::class.java)
                intent.putExtra("vaqt",vaqt.toString())
                intent.putExtra("qayerga",qayergaSave.candidates.get(0).formatted_address.toString())
                intent.putExtra("ga_lat",qayergaSave.candidates.get(0).geometry.location.lat.toString())
                intent.putExtra("ga_lng",qayergaSave.candidates.get(0).geometry.location.lng.toString())
                intent.putExtra("qayerdan",qayerdanSave.candidates.get(0).formatted_address.toString())
                intent.putExtra("dan_lat",qayerdanSave.candidates.get(0).geometry.location.lat.toString())
                intent.putExtra("dan_lng",qayerdanSave.candidates.get(0).geometry.location.lng.toString())
                 startActivity(intent)
            }catch (e:Exception){
                Toast.makeText(requireContext(), "Malumotlarni to`liq kiriting!!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun taxiQachon() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.taxiQachon.setOnClickListener {
            fragmentManager?.let { it1 -> datePicker.show(it1, "tag") }
        }
        datePicker.addOnPositiveButtonClickListener { selection: Long? ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.time = selection?.let { Date(it) }
            val time = taxiQachonQachongachaText(
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_WEEK)
            )
            binding.qachonDefault.visibility = View.INVISIBLE
            binding.qachonTanlanganda.visibility = View.VISIBLE
            binding.qachonText.visibility = View.VISIBLE
            binding.qachonText.setText(time)
            vaqt = "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH)+1}/${calendar.get(Calendar.YEAR)}"
        }
    }

    private fun taxiQachonQachongachaText(kun: Int, oy: Int, haftaKuni: Int): String {
        val oytext = when (oy + 1) {
            1 -> "Yan"
            2 -> "Fev"
            3 -> "Mar"
            4 -> "Apr"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "Aug"
            9 -> "Sep"
            10 -> "Oct"
            11 -> "Noya"
            12 -> "Dek"
            else -> {}
        }
        val haftaKuniText = when (haftaKuni) {
            1 -> "Yak"
            2 -> "Dush"
            3 -> "Sesh"
            4 -> "Chor"
            5 -> "Pay"
            6 -> "Juma"
            7 -> "Shan"
            else -> {}
        }
        return ((kun.toString() + " " + oytext + "," + haftaKuniText))
    }

    private fun taxiQayerdan() {
        binding.taxiQayerdanBtn.setOnClickListener {
            val bottomsheet = BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
            val view =
                LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
            val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
            bottomsheet.setContentView(view)
            bottomsheetBinding.chiqish.setOnClickListener {
                bottomsheet.dismiss()
            }
            bottomsheet.show()
            bottomsheetBinding.shaxarIzlash.setOnQueryTextListener(object :
                SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    qayerdanShaxarIzlashSurov(query, bottomsheet)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }

    }

    private fun qayerdanShaxarIzlashSurov(query: String, bottomsheet: BottomSheetDialog) {
        taxiViewModel.taxiManzilQidirish(
            query,
            "textquery",
            "AIzaSyAyOUon_jgkDh8kDSCQvHJEdj9xt6QFoXc") {
            if (it.isSuccessful) {
                qayerdanSave = it.body()!!
                binding.apply {
                    qayerdanTxtTop.visibility = View.VISIBLE
                    qayerdanTxtMain.setText(it.body()!!.candidates.get(0).formatted_address)
                    bottomsheet.dismiss()
                }

            } else {
                D.d("TaxiQidirish taxiViewModel funi")
            }
        }
    }

    override fun onclickView(type: String) {

    }

    private fun taxiQayerga() {
        binding.taxiQayergaBtn.setOnClickListener {
            val bottomsheet = BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
            val view =
                LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
            val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
            bottomsheet.setContentView(view)
            bottomsheetBinding.chiqish.setOnClickListener {
                bottomsheet.dismiss()
            }
            bottomsheetBinding.textView11.setText("Qayerga")

            bottomsheet.show()

            bottomsheetBinding.shaxarIzlash.setOnQueryTextListener(object :
                SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    qayergaShaxarIzlashSurov(query, bottomsheet)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }
    }


    private fun qayergaShaxarIzlashSurov(query: String, bottomsheet: BottomSheetDialog) {
        taxiViewModel.taxiManzilQidirish(
            query,
            "textquery",
            "AIzaSyAyOUon_jgkDh8kDSCQvHJEdj9xt6QFoXc") {
            if (it.isSuccessful) {
                qayergaSave = it.body()!!
                binding.apply {
                    qayergaTxtTop.visibility = View.VISIBLE
                    qayergaTxtMain.setText(it.body()!!.candidates.get(0).formatted_address)
                    bottomsheet.dismiss()
                }

            } else {
                D.d("TaxiQidirish taxiViewModel funi")
            }
        }
    }

    /*----------------Tegma----------------------*/


}