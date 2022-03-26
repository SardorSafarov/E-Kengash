package com.example.chapMenu.sozlanmalar.dasturTili

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants
import com.example.katrip.R
import com.example.katrip.databinding.ActivityDasturTiliBinding
import com.example.katrip.main.MainActivity
import java.util.*

class DasturTili : AppCompatActivity() {
    lateinit var binding:ActivityDasturTiliBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDasturTiliBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        sharedPreferences = getSharedPreferences(Constants.LocalTilKey, MODE_PRIVATE)!!
        setOnClickListener()
    }
    private fun setOnClickListener() {

        binding.tilUz.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","en-us")
                apply()
                commit()
                setApplicationLocale("en-us")
            }
         startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
        binding.tilRu.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","ru")
                apply()
                commit()
                setApplicationLocale("ru")
            }
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
        binding.tilEn.setOnClickListener{
            sharedPreferences.edit().apply {
                putString("til","en")
                apply()
                commit()
                setApplicationLocale("en")
            }
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
        binding.orqagaQaytish.setOnClickListener {
            finish()
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