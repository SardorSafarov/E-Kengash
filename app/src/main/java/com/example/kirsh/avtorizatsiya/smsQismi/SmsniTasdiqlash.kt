package com.example.kirsh.avtorizatsiya.smsQismi

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kirsh.avtorizatsiya.ruyxatdanUtish.TelNomerViewModel
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentSmsniTasdiqlashBinding
import com.example.ekengash.main.MainActivity
import com.example.kirsh.surovnoma.sayohatTurlari.SayohatTurlari
import com.example.log.D
import com.example.network.netWorkEndtity.sms.smsKeldi.javob.SmsKeldiJavob
import com.example.network.netWorkEndtity.sms.smsKeldi.surov.SmsKeldiSurov
import com.example.network.netWorkEndtity.sms.telNumberJunatish.surov.SmsSurov
import com.example.network.repository.KirishRepository
import com.example.network.viewModelFactory.KirishViewModelFactory
import com.example.network.viewmodel.KirishViewModel
import com.example.room.roomEntity.UserEntity
import com.example.room.viewModel.UserViewModel
import retrofit2.Response


class SmsniTasdiqlash : Fragment() {
    private var _binding: FragmentSmsniTasdiqlashBinding? = null
    private val binding get() = _binding!!
    private var telNomerViewModel: TelNomerViewModel? = null
    private lateinit var kirishViewModel: KirishViewModel
    private var telNumber=""
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmsniTasdiqlashBinding.inflate(inflater, container, false)
        telNumberniOlish()
        val view = binding.root
        setUi()
        smsSurovJunatishBtn()
        smsTasdiqlash()
        return view
    }

    private fun setUi() {
        val kirishRepository = KirishRepository()
        val kirishViewModelFactory = KirishViewModelFactory(kirishRepository)
        val kirishViewModel = ViewModelProvider(
            this,
            kirishViewModelFactory
        ).get(KirishViewModel::class.java)
        this.kirishViewModel = kirishViewModel
    }
    private fun smsSurovJunatishBtn() {
        binding.kodVaqt.setOnClickListener {
            smsSurovJunatishBtn()
            binding.kodVaqtB.visibility = View.VISIBLE
            smsSurov()
        }

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.kodVaqt.setText("00: " + String.format("%02d", millisUntilFinished / 1000))
            }

            override fun onFinish() {
                binding.kodVaqtB.visibility = View.GONE
                binding.kodVaqt.setTextColor(resources.getColor(R.color.kuk))
                binding.kodVaqt.setText("Sms kelmadimi?")
            }
        }.start()
        binding.kodVaqtB.setOnClickListener {

        }
    }

    private fun smsTasdiqlash() {
        binding.tasdiqlashButton.setOnClickListener {
            kirishViewModel.smsKeldi(body = SmsKeldiSurov(code = binding.kodText.text.toString(), phone = telNumber)){
                smsKeldiJavob(it)
            }

        }
    }

    private fun smsKeldiJavob(response: Response<SmsKeldiJavob>) {
        if (response.isSuccessful)
        {
            if(response.body()?.status=="success")
            {
                userViewModel.insertUser(UserEntity(
                    full_name = response.body()!!.data.user.full_name,
                    token = response.body()!!.data.token,
                    phone = binding.telNumber.text.toString(),
                    balans = response.body()!!.data.user.balanc
                ))
               startActivity(Intent(requireContext(),SayohatTurlari::class.java))
                activity?.finish()
            }else
            {
                D.d("SmsTasdiqlash smsKeldiJavob ishlamadi")
            }
        }
    }


    private fun smsSurov() {

        kirishViewModel.smsgaSurovTashlash(SmsSurov(telNumber)) {}
    }


    private fun telNumberniOlish() {
        telNomerViewModel =
            ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)
        telNomerViewModel!!.telNomer.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(t: Any?) {
                telNumber = t.toString()
                telNumber(t.toString())
            }
        })
    }

    fun telNumber(telNumber: String) {
        binding.telNumber.text = "+998" + telNumber

    }
}