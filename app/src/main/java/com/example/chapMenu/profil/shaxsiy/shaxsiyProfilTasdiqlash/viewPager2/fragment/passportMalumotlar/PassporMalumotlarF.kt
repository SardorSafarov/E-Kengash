package com.example.chapMenu.profil.shaxsiy.shaxsiyProfilTasdiqlash.viewPager2.fragment.passportMalumotlar

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants
import com.example.katrip.R
import com.example.katrip.databinding.AlertDiaolgSmsTasdiqlashBinding
import com.example.katrip.databinding.FragmentPassporMalumotlarBinding
import com.example.log.D
import com.example.network.entity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewModelFactory.kirish.ProfilViewModelFactory
import com.example.network.viewmodel.profil.ProfilViewModel


class PassporMalumotlarF : Fragment() {
    private var _binding: FragmentPassporMalumotlarBinding? = null
    private val binding get() = _binding!!
    private lateinit var profilViewModel: ProfilViewModel
    private val validatsitaMessage = "to'ldirilishi shart"
    private lateinit var tugashDialog: AlertDialog.Builder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentPassporMalumotlarBinding.inflate(inflater, container, false)
        val view = binding.root
        setUi()
        setOnClickListener()
        statusBar()
        return view
    }

    private fun statusBar() {
        activity?.window?.statusBarColor = Color.parseColor("#F3F3F3")
    }

    private fun setOnClickListener() {

        davomEtish()
        orqagaQaytish()
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

    private fun davomEtish() {
        val errorDialog = AlertDialog.Builder(requireContext())
        errorDialog.apply {
            setTitle("Xatolik!!")
            setTitle("Xatolik!!")
            setPositiveButton("Tushundim") { dialogInterface: DialogInterface, i: Int -> }
        }
        tugashDialog = AlertDialog.Builder(requireContext())
        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.alert_diaolg_sms_tasdiqlash, null)
        tugashDialog.apply {
            setView(view)
        }

        val bind = AlertDiaolgSmsTasdiqlashBinding.bind(view)
        bind.profilBoshSahifagaQaytish.setOnClickListener {
            activity?.finish()
        }
        binding.davomEtishButton.setOnClickListener {
            if (validatsiyaEditText()) {
                passportMalumotlarQushish()

            } else {
                errorDialog.show()
            }

        }
    }

    private fun passportMalumotlarQushish() {
        profilViewModel.passportMalumotlarQushish(Constants.TOKEN, PassportMalumotlarSurov(
            jshir = binding.passportJshsher.text.toString(),
            give_date = binding.passportBerilgan.text.toString().reversed(),
            end_date = binding.passportAmalqilishUddati.text.toString().reversed(),
            number = binding.passportSeriya.text.toString(),
            country = binding.tugulganDavlati.text.toString(),
            address = binding.doimyYashash.text.toString(),
            name = binding.passportKimBerdi.text.toString()
        )) {
            if (it.isSuccessful) {
                if (it.body()!!.status == "success"){
                    D.d(it.body().toString())
                    tugashDialog.show()
                }
                    Toast.makeText(requireContext(), "Ma'lumolar qo'shildi", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }

    private fun validatsiyaEditText(): Boolean {
        binding.apply {
            if (passportSeriya.text?.length == 0) {
                passportSeriyaEdit.error = "Seriyasini $validatsitaMessage"
                return false
            }
            if (passportJshsher.text?.length == 0) {
                passportJshsherEdit.error = "JSHSHIRni $validatsitaMessage"
                return false
            }
            if (passportKimBerdi.text?.length == 0) {
                passportKimBerdiEdit.error = "Kim tomonidan berilganni $validatsitaMessage"
                return false
            }
            if (passportBerilgan.text?.length == 0) {
                passportBerilganEdit.error = "Berilgan vaqtini $validatsitaMessage"
                return false
            }
            if (passportAmalqilishUddati.text?.length == 0) {
                passportAmalqilishUddatiEdit.error = "Amal qilish muddatini $validatsitaMessage"
                return false
            }
            if (tugulganDavlati.text?.length == 0) {
                tugulganDavlatiEdit.error = "Tug'ulgan davlatni $validatsitaMessage"
                return false
            }
            if (doimyYashash.text?.length == 0) {
                doimiyYashashEdit.error = "Doimiy yashashni $validatsitaMessage"
                return false
            }


        }
        return true
    }


    private fun orqagaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            findNavController().navigate(R.id.action_passporMalumotlarF_to_shaxsiyMalumotlarF)
        }
    }

}