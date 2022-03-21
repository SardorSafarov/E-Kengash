package com.example.kirsh.avtorizatsiya.kirshQismi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kirsh.avtorizatsiya.ruyxatdanUtish.RuyxatdanUtishTuliq
import com.example.kirsh.avtorizatsiya.ruyxatdanUtish.TelNomerViewModel
import com.example.kirsh.avtorizatsiya.smsQismi.SmsniTasdiqlash
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKirishQismiBinding
import com.example.ekengash.main.MainActivity
import com.example.log.D
import com.example.network.netWorkEndtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.netWorkEndtity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.netWorkEndtity.sms.telNumberJunatish.surov.SmsSurov
import com.example.network.repository.kirish.KirishRepository
import com.example.network.viewModelFactory.kirish.KirishViewModelFactory
import com.example.network.viewmodel.kirish.KirishViewModel
import com.example.room.roomEntity.UserEntity
import com.example.room.viewModel.UserViewModel
import retrofit2.Response


class KirishQismi : Fragment() {
    private var _binding: FragmentKirishQismiBinding? = null
    private val binding get() = _binding!!
    private lateinit var kirishViewModel: KirishViewModel
    private var checkUser = ""
    private val userViewModel: UserViewModel by activityViewModels()
    private var telNomerViewModel: TelNomerViewModel? = null
    //Click listenrlani iloji bulsa onCreateViewda qoyib oling

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKirishQismiBinding.inflate(inflater, container, false)
        setUi()
        binding.apply {
            davomEtishButton.setOnClickListener {
                val parolText = parol.text.toString()
                if (parolText.isNotEmpty()) {
                    kirishViewModel.parolniTekshirish(
                        ParolniTekshirishSurov(
                            password = binding.parol.text.toString().trim(),
                            username = "998" + binding.telNumber.text.toString()
                        )
                    )
                }
                else
                {
                    kirishViewModel.smsgaSurovTashlash(SmsSurov( binding.telNumber.text.toString()))
                    {
                        onResponseSms(it)
                    }
                }
            }
        }
        kirishViewModel.parolniTekshirish.observe(viewLifecycleOwner, Observer {
            if (it.isSuccessful) {
                if (it.body()!!.status == "success") {
                   userViewModel.insertUser(
                       UserEntity(
                            full_name = it.body()!!.data.user.full_name,
                           phone = it.body()!!.data.user.username,
                           token = it.body()!!.data.token
                       )
                   )
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    activity?.finish()
                } else {
                    binding.textView24r.setText("Parol xato!!")
                }

            } else {
                D.d("KirishQismi parolniTekshirishga qara")
            }
        })
        return binding.root
    }

    private fun onResponseSms(response: Response<SmsJavob>) {
        if(response.isSuccessful)
        {
            if(response.body()?.status=="success"){
                telNomerViewModel =
                    ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)
                telNomerViewModel!!.telNomer(binding.telNumber.text.toString())
                requireFragmentManager()?.beginTransaction()
                    ?.replace(R.id.kirsh_qismidagi_fragment, SmsniTasdiqlash())
                    ?.addToBackStack(null)?.commit()
            }

        }else{
            D.d("KishQismidagi onResponseSms ishlamadi")
        }
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

    /*----------------------Teginma------------------------------------*/



    fun onResponse(response: Response<FooydalanuvchiniTekshirish>?) {
        response?.let {
            if (it.isSuccessful) {
                checkUser = it.body()!!.data.check
                if (checkUser == "Yes") {
                    binding.linearLayout7r.visibility = View.VISIBLE
                    binding.textView24r.visibility = View.VISIBLE
                    binding.parolniUnutdinggizmi.visibility = View.VISIBLE
                    binding.textView24r.text = "Parolni kiriting"
                } else {
                    telNomerViewModel =
                        ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)
                    telNomerViewModel!!.telNomer(binding.telNumber.text.toString())
                    requireFragmentManager()?.beginTransaction()
                        ?.replace(R.id.kirsh_qismidagi_fragment, RuyxatdanUtishTuliq())
                        ?.addToBackStack(null)?.commit()
                }
            }
            else
            {
                D.d("KirishQismi telJunatish ishlamadi")
            }
        }
    }
}