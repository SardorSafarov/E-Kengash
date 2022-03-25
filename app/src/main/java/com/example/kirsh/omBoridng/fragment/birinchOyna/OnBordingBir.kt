package com.example.kirsh.omBoridng.fragment.birinchOyna

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants.SHAREDPREF_KEY
import com.example.constants.Constants.TIL
import com.example.katrip.R
import com.example.katrip.databinding.FragmentOnBordingBirBinding
import com.example.log.D
import java.util.*


class OnBordingBir : Fragment() {
    private var _binding: FragmentOnBordingBirBinding? = null
    private val binding get() = _binding!!
    lateinit var title: Array<String>
    lateinit var sub_title: Array<String>
    lateinit var button:Array<String>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var lan: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOnBordingBirBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        binding.davomEtishButton.setOnClickListener {
            findNavController().navigate(R.id.action_onBordingBir_to_ikkiOnBording)
        }
        sharedPreferences = requireActivity().getSharedPreferences(SHAREDPREF_KEY, AppCompatActivity.MODE_PRIVATE)
        lan = sharedPreferences.getString("key", null).toString()
        D.d(lan)
        setApplicationLocale("ru")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        til()
    }
    private fun setApplicationLocale(locale: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(locale.toLowerCase()))
        } else {
            config.locale = Locale(locale.toLowerCase())
        }
        resources.updateConfiguration(config, dm)
    }

    private fun til() {
//        when (TIL) {
//            "uz" -> {
//                binding.title.setText(title[0])
//                binding.subTitle.setText(sub_title[0])
//                binding.btnText.setText(button[0])
//            }
//            "ru" -> {
//                binding.title.setText(title[3])
//                binding.subTitle.setText(sub_title[3])
//                binding.btnText.setText(button[1])
//
//            }
//            "en" -> {
//                binding.title.setText(title[6])
//                binding.subTitle.setText(sub_title[6])
//                binding.btnText.setText(button[2])
//            }
//        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        title = resources.getStringArray(R.array.on_bording_title)
        sub_title = resources.getStringArray(R.array.on_bording_subtitle)
        button = resources.getStringArray(R.array.on_bording_tugmalar)
    }
}