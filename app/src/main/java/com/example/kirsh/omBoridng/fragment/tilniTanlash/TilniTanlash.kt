package com.example.kirsh.omBoridng.fragment.tilniTanlash

import android.content.Context.MODE_PRIVATE
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
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants.SHARED_KEY
import com.example.constants.Constants.TIL
import com.example.katrip.R
import com.example.katrip.databinding.FragmentTilniTanlashBinding
import java.util.*


class TilniTanlash : Fragment() {
    private var _binding: FragmentTilniTanlashBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTilniTanlashBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        sharedPreferences = activity?.getSharedPreferences(SHARED_KEY, MODE_PRIVATE)!!
        activity?.window?.statusBarColor = resources.getColor(R.color.asosiy_orqa_ranggi)

        return view
    }

    private fun setOnClickListener() {

        binding.tilUz.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","en-us")
                apply()
                commit()
                setApplicationLocale("en-us")
            }

            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
        }
        binding.tilRu.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","ru")
                apply()
                commit()
                setApplicationLocale("ru")
            }
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
        }
        binding.tilEn.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","en")
                apply()
                commit()
                setApplicationLocale("en")
            }
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
        }
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
}