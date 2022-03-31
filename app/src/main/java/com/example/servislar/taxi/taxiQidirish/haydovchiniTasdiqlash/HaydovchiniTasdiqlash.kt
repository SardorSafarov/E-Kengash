package com.example.servislar.taxi.taxiQidirish.haydovchiniTasdiqlash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.katrip.databinding.ActivityHaydovchiniTasdiqlashBinding
import com.example.log.D

class HaydovchiniTasdiqlash : AppCompatActivity() {
    private lateinit var binding:ActivityHaydovchiniTasdiqlashBinding
    var narxi=0
    var yulovchilar=1
    var umumiyNarx=0
    var boshurinlar=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaydovchiniTasdiqlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        narxi = intent.getStringExtra(("price")).toString().toInt()
        umumiyNarx = intent.getStringExtra(("price")).toString().toInt()*yulovchilar
        boshurinlar = intent.getStringExtra(("seats")).toString().toInt()
        binding.yulovchiSoni.setText("${yulovchilar} X ${narxi} = $umumiyNarx")
        window.statusBarColor = Color.WHITE
        ortgaQaytish()
        haydovchiHaqida()
        yulovchiSoni()
    }

    private fun yulovchiSoni() {

        binding.yulovchiQush.setOnClickListener {
            try {
                if(yulovchilar!=boshurinlar)
                    yulovchilar++
                umumiyNarx = narxi*yulovchilar
                umumiyNarx(yulovchilar, umumiyNarx, narxi)
            }catch (e:Exception)
            {
                D.d("${e.message}")
            }

        }
        binding.yulovchiAyir.setOnClickListener {
            try {
                if(yulovchilar!=1)
                    yulovchilar--
                umumiyNarx = narxi*yulovchilar
                umumiyNarx(yulovchilar, umumiyNarx, narxi)
            }catch (e:Exception)
            {
                D.d("${e.message}")
            }

        }
    }
    fun umumiyNarx(yulovchilar: Int, umumiyNarx: Int, narxi: Int) {
        D.d("keldi $yulovchilar  $narxi  $umumiyNarx")
        binding.yulovchilarSoni.setText(yulovchilar.toString())
        binding.yulovchiSoni.setText("${yulovchilar.toString()} X ${narxi.toString()} = ${umumiyNarx.toString()}")
    }

    private fun haydovchiHaqida() {
        binding.apply {
            Glide.with(this@HaydovchiniTasdiqlash).load(intent.getStringExtra(("image")).toString()).into(image)
            price.setText(intent.getStringExtra(("price")).toString()+" UZS")
            name.setText(intent.getStringExtra(("driver")).toString())
            seats.setText(intent.getStringExtra(("seats")).toString())
            duration.setText(intent.getStringExtra(("duration")).toString())
            distance.setText(intent.getStringExtra(("distance")).toString())
            departureTime.setText(intent.getStringExtra(("departure_time")).toString())
            borishKuni.setText(intent.getStringExtra("vaqt"))
            mashinaRanggi.setText(intent.getStringExtra("mashinaRanggi"))
            manzillar.setText(intent.getStringExtra("qayerdan"))
            distance.setText(intent.getStringExtra("distance"))

        }
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}