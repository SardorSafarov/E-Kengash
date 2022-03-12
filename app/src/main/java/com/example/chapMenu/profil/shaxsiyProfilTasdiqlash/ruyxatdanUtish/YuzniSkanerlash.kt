package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.ruyxatdanUtish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityYuzniSkanerlashBinding

class YuzniSkanerlash : AppCompatActivity() {
    lateinit var binding:ActivityYuzniSkanerlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYuzniSkanerlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}