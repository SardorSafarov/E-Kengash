package com.example.kirsh.avtorizatsiya.kirshQismi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kirsh.avtorizatsiya.ruyxatdanUtish.RuyxatdanUtishTuliq
import com.example.kirsh.avtorizatsiya.ruyxatdanUtish.TelNomerViewModel
import com.example.kirsh.avtorizatsiya.smsQismi.SmsniTasdiqlash
import com.example.katrip.R
import com.example.katrip.databinding.FragmentKirishQismiBinding
import com.example.katrip.main.MainActivity
import com.example.log.D
import com.example.network.endtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.endtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.endtity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.endtity.sms.telNumberJunatish.surov.SmsSurov
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
        topMenu()
        return binding.root
    }



    private fun topMenu() {
        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.mamlakat_kodi -> {
                    showPopup(view)
                }
            }
        }
        binding.mamlakatKodi.setOnClickListener(clickListener)

    }



    @SuppressLint("RestrictedApi")
    private fun showPopup(view: View) {

        val menuBuilder = MenuBuilder(requireContext())
        val inflater = MenuInflater(requireContext())
        inflater.inflate(R.menu.tel_kod, menuBuilder)

        val optionsMenu = MenuPopupHelper(requireContext(), menuBuilder, view)
        optionsMenu.setForceShowIcon(true)
        menuBuilder.setCallback(object : MenuBuilder.Callback {
            override fun onMenuItemSelected(menu: MenuBuilder, item: MenuItem): Boolean {
                when(item.itemId)
                {
                   R.id.tel_uz->{
                       binding.flag.setImageResource(R.drawable.uz)
                       binding.kod.text=item.title
                   }
                    R.id.tel_arab->{
                        binding.flag.setImageResource(R.drawable.arab)
                        binding.kod.text=item.title
                    }
                    R.id.tel_usa->{
                        binding.flag.setImageResource(R.drawable.us)
                        binding.kod.text=item.title
                    }
                    R.id.tel_ru->{
                        binding.flag.setImageResource(R.drawable.ru)
                        binding.kod.text=item.title
                    }
                    R.id.tel_kz->{
                        binding.flag.setImageResource(R.drawable.kz)
                        binding.kod.text=item.title
                    }
                    R.id.tel_kirgiz->{
                        binding.flag.setImageResource(R.drawable.kirgiz)
                        binding.kod.text=item.title
                    }
                    R.id.tel_tj->{
                        binding.flag.setImageResource(R.drawable.tj)
                        binding.kod.text=item.title
                    }
                    R.id.tel_turkiya->{
                        binding.flag.setImageResource(R.drawable.turkiya)
                        binding.kod.text=item.title
                    }
                    R.id.tel_turkman->{
                        binding.flag.setImageResource(R.drawable.turkman)
                        binding.kod.text=item.title
                    }
                    R.id.tel_koreya->{
                        binding.flag.setImageResource(R.drawable.koreya)
                        binding.kod.text=item.title
                    }
                    R.id.tel_india->{
                        binding.flag.setImageResource(R.drawable.ind)
                        binding.kod.text=item.title
                    }
                    R.id.tel_italiya->{
                        binding.flag.setImageResource(R.drawable.italiya)
                        binding.kod.text=item.title
                    }
                    else -> false
                }
                return true
            }

            override fun onMenuModeChange(menu: MenuBuilder) {}
        })
        optionsMenu.show()

    }

    private fun onResponseSms(response: Response<SmsJavob>) {
        if(response.isSuccessful)
        {
            if(response.body()?.status=="success"){
                telNomerViewModel =
                    ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)
                telNomerViewModel!!.telNomer(binding.telNumber.text.toString())
                telNomerViewModel!!.flag(binding.flag)
                telNomerViewModel!!.telKode(binding.kod.text.toString())
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