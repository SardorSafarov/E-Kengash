package com.example.avtorizatsiya.smsQismi

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.avtorizatsiya.ruyxatdanUtish.RuyxatdanUtishTuliq
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentSmsniTasdiqlashBinding
import com.example.log.D


class SmsniTasdiqlash : Fragment() {
    private var _binding: FragmentSmsniTasdiqlashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmsniTasdiqlashBinding.inflate(inflater, container, false)

        val view = binding.root
        return view
    }

    private fun yanaSmsJunatish() {
        binding.kodVaqt.setOnClickListener {
            yanaSmsJunatish()
            binding.kodVaqtB.visibility = View.VISIBLE
            D.d("text bosild")
        }
        binding.kodVaqtB.setOnClickListener {
            D.d("btn bosildi")
        }
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.kodVaqt.setText("00: " +String.format("%02d",  millisUntilFinished / 1000))
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                binding.kodVaqtB.visibility = View.GONE
                binding.kodVaqt.setTextColor(resources.getColor(R.color.kuk))
                binding.kodVaqt.setText("Sms kelmadimi?")
            }
        }.start()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        yanaSmsJunatish()
        binding.tasdiqlashButton.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,RuyxatdanUtishTuliq()).commit()
        }

    }







}