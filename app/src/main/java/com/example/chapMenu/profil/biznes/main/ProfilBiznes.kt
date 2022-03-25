package com.example.chapMenu.profil.biznes.main


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chapMenu.profil.biznes.biznesProfilQushish.BiznesProfilQushish
import com.example.constants.Constants
import com.example.katrip.databinding.FragmentProfilBiznesBinding
import com.example.log.D
import com.example.network.entity.profil.user.UsersOrg
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewModelFactory.kirish.ProfilViewModelFactory
import com.example.network.viewmodel.profil.ProfilViewModel

class ProfilBiznes : Fragment() {
    private var _binding: FragmentProfilBiznesBinding? = null
    private val binding get() = _binding!!
    private lateinit var profilViewModel: ProfilViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBiznesBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        instalizatsiya()
        return view
    }
    private fun instalizatsiya() {
        setUi()
    }
    private fun setOnClickListener() {
       biznesProfilQushish()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        foydalanuvchiniTekshirish()
    }
    override fun onResume() {
        super.onResume()
        foydalanuvchiniTekshirish()
    }

    private fun setUi() {
        val profilRepository = ProfilRepository()
        val profilViewModelFactory =
            ProfilViewModelFactory(profilRepository)
        val profilViewModel = ViewModelProvider(
            this,
            profilViewModelFactory
        ).get(ProfilViewModel::class.java)
        this.profilViewModel = profilViewModel
    }


    fun foydalanuvchiniTekshirish() {
        profilViewModel.userHaqida(Constants.TOKEN) {
            if (it.isSuccessful) {
                binding.progress.visibility = View.GONE
                if (it.body()!!.data.usersOrg.org_stir != null) {
                    userData(it.body()!!.data.usersOrg)
                    D.d(it.body()!!.data.userPassport.toString())
                    binding.userTasdiqlanmagan.visibility = View.GONE
                    binding.userTasdiqlangan.visibility = View.VISIBLE
                } else {
                    binding.userTasdiqlanmagan.visibility = View.VISIBLE
                    binding.userTasdiqlangan.visibility = View.GONE
                }
            }
        }
    }

    private fun userData(userData: UsersOrg) {
        binding.apply {
            tashTuri.setText(userData.org_type)
            korTashNomi.setText(userData.org_name)
            tashRasmiyNomi.setText(userData.org_official_name)
            direktor.setText(userData.org_director_name)
            tashTel.setText(userData.org_phone)
            qushTel.setText(userData.org_phone2)
            tashEmail.setText(userData.org_email)
            tashStir.setText(userData.org_stir)
            bankNomi.setText(userData.org_bank_name)
            tashMfo.setText(userData.org_bank_mfo)
            tashHisobRaqam.setText(userData.org_bank_accauntnumber)
            tashDavlatShahar.setText(userData.org_country)
            tashYuridikManzil.setText(userData.org_official_adress)
            tashPochtaIndeksi.setText(userData.org_postindex)

        }
    }





    private fun biznesProfilQushish() {
        binding.biznesProfilQushish.setOnClickListener {
          startActivity(Intent(requireContext(),BiznesProfilQushish::class.java))
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}