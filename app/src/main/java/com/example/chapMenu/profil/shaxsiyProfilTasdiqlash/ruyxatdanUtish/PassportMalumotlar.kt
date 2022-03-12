package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.ruyxatdanUtish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityPassportMalumotlarBinding

class PassportMalumotlar : AppCompatActivity() {
    private lateinit var binding:ActivityPassportMalumotlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPassportMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}