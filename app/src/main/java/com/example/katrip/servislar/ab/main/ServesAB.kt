package com.example.katrip.servislar.ab.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katrip.R
import com.example.katrip.databinding.ActivityServesAbBinding
import com.example.katrip.databinding.BottomSheetAviaHolatBinding
import com.example.katrip.databinding.BottomSheetServesQayerdanBinding
import com.example.katrip.fragmentlar.asosiyy.adapter.TakliflarLayfxaklarAdapter
import com.example.log.D
import com.example.network.entity.takliflarLayfxaklar.javob.Arr
import com.example.network.repository.takliflarLayfxaklar.TakliflarLayfxaklarRepisitory
import com.example.network.viewModelFactory.takliflarLayfxaklar.TakliflarLayfxaklarViewModelFactory
import com.example.network.viewmodel.takliflarLayfxaklar.TakliflarLayfxaklarViewModel
import com.example.room.viewModel.UserViewModel
import com.example.katrip.servislar.ab.izlash.ABIzlash
import com.example.katrip.servislar.stories.TakliflarLayfxaklarFullScreen
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class ServesAB : AppCompatActivity(),TakliflarLayfxaklarAdapter.onClickListener {
    private lateinit var binding: ActivityServesAbBinding
    var kattalar = 1
    var bolalar = 0
    var chaqaloqlar = 0
    private lateinit var takliflarLayfxaklarViewModel: TakliflarLayfxaklarViewModel
    private val takliflarLayfxaklarAdapter: TakliflarLayfxaklarAdapter by lazy { TakliflarLayfxaklarAdapter(this, applicationContext = applicationContext) }
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesAbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        poyezdHolat()
        izlash()
        statusBar()
        orqagaQaytish()
        abQayerdan()
        abQayerga()
        abQachon()
        layfxaklarSetUi()
        takliflarLayfxaklar()
    }



    private fun layfxaklarSetUi() {
        val takliflarLayfxaklarRepisitory = TakliflarLayfxaklarRepisitory()
        val takliflarLayfxaklarViewModelFactory = TakliflarLayfxaklarViewModelFactory(takliflarLayfxaklarRepisitory)
        val takliflarLayfxaklarViewModel = ViewModelProvider(
            this,
            takliflarLayfxaklarViewModelFactory
        ).get(TakliflarLayfxaklarViewModel::class.java)
        this.takliflarLayfxaklarViewModel = takliflarLayfxaklarViewModel

    }


    private fun takliflarLayfxaklar() {
        userViewModel.readUser.observe(this, androidx.lifecycle.Observer {

            takliflarLayfxaklarViewModel.takliflarLayfxaklar(it.get(0).token.toString(),"aToB")
            {
                if(it.isSuccessful){
                    taklifLafxaklarsetAdapterData(it.body()!!.data.arr)
                }else
                {
                    D.d("Asosiy takliflarLayfxaklar funida")
                }
            }
        })

    }
    private fun taklifLafxaklarsetAdapterData(arr: List<Arr>) {
        binding.apply {
            takliflarLayfhaklarRecyc.adapter = takliflarLayfxaklarAdapter
            takliflarLayfhaklarRecyc.layoutManager = LinearLayoutManager(this@ServesAB,
                LinearLayoutManager.HORIZONTAL,false)
            takliflarLayfxaklarAdapter.setData(arr)
        }

    }
    override fun onClickListener(item: Arr) {
        val intent = Intent(this, TakliflarLayfxaklarFullScreen::class.java)
        intent.putExtra("text1",item.content1)
        intent.putExtra("text2",item.content2)
        intent.putExtra("text3",item.content3)
        intent.putExtra("name",item.name)
        intent.putExtra("image",item.image_link)
        startActivity(intent)
    }




    private fun abQachon() {

//        val calendar = Calendar.getInstance()
//        val kun = calendar[Calendar.DAY_OF_MONTH]
//        val haftaKuni = calendar[Calendar.DAY_OF_WEEK]
//        val oy = calendar[Calendar.MONTH]
//        abQachonText(kun = kun, oy = oy, haftaKuni = haftaKuni)


        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.abQachon.setOnClickListener {
            supportFragmentManager?.let { it1 -> datePicker.show(it1, "tag") }
        }
        datePicker.addOnPositiveButtonClickListener { selection: Long? ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.time = selection?.let { Date(it) }
            abQachonText(
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_WEEK)
            )
            binding.abQachonDefault.visibility = View.INVISIBLE
            binding.qachonTanlangan.visibility= View.VISIBLE
            binding.abQachonText.visibility = View.VISIBLE
        }

    }

    private fun abQachonText(kun: Int, oy: Int, haftaKuni: Int) {

        val oytext = when (oy + 1) {
            1 -> "Yan"
            2 -> "Fev"
            3 -> "Mar"
            4 -> "Apr"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "Aug"
            9 -> "Sep"
            10 -> "Oct"
            11 -> "Noya"
            12 -> "Dek"

            else -> {}
        }
        val haftaKuniText = when (haftaKuni) {
            1 -> "Yak"
            2 -> "Dush"
            3 -> "Sesh"
            4 -> "Chor"
            5 -> "Pay"
            6 -> "Juma"
            7 -> "Shan"
            else -> {}
        }
        binding.abQachonText.setText((kun.toString() + " " + oytext + "," + haftaKuniText))
    }

    private fun abQayerdan() {
        val bottomsheet = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.abQayerdan.setOnClickListener {
            bottomsheet.show()
        }
    }

    private fun abQayerga() {
        val bottomsheet = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        bottomsheetBinding.textView11.setText(this.getString(R.string.qayerga))
        binding.abQayerga.setOnClickListener {
            bottomsheet.show()
        }
    }




    private fun izlash() {
        binding.abIzlash.setOnClickListener {
            startActivity(Intent(this, ABIzlash::class.java))
        }
    }

    private fun poyezdHolat() {

        val bottomDialog = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_avia_holat, null)
        bottomDialog.setContentView(view)
        binding.abHolat.setOnClickListener {
            bottomDialog.show()
        }

        val abHolatBinding = BottomSheetAviaHolatBinding.bind(view)
        abHolatBinding.davomEtishButton.setOnClickListener {
            val umumiyKishilar = kattalar+bolalar+chaqaloqlar
            if(umumiyKishilar!=0){
                binding.holatDefault.visibility = View.INVISIBLE
                binding.holatTanlanganda.visibility = View.VISIBLE
                binding.holatText.visibility = View.VISIBLE
                binding.holatText.setText(umumiyKishilar.toString()+" ${this.getString(R.string.kishi)}")
            }
            else{
                binding.holatDefault.visibility = View.VISIBLE
                binding.holatTanlanganda.visibility = View.INVISIBLE
                binding.holatText.visibility = View.INVISIBLE
            }
            bottomDialog.dismiss()
        }

        abHolatBinding.beletTuri.visibility = View.GONE
        abHolatBinding.orqagaQaytish.setOnClickListener {
            bottomDialog.dismiss()
        }
/*-------------Kattalar------------------*/
        abHolatBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            abHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            abHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            abHolatBinding.holatKattalarSoni.text = kattalar.toString()
        }
        abHolatBinding.holatKattalarKam.setOnClickListener {
            if (kattalar > 1) {
                kattalar--
                if (kattalar == 1) {
                    abHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    abHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                abHolatBinding.holatKattalarSoni.text = kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        abHolatBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            abHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            abHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            abHolatBinding.bolalarSoni.text = bolalar.toString()
        }
        abHolatBinding.holatBolalarKam.setOnClickListener {
            if (bolalar > 0) {
                bolalar--
                if (bolalar == 0) {
                    abHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    abHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                abHolatBinding.bolalarSoni.text = bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        abHolatBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            abHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            abHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            abHolatBinding.holatChaqaloqSoni.text = chaqaloqlar.toString()
        }
        abHolatBinding.holatChaqaloqKam.setOnClickListener {
            if (chaqaloqlar > 0) {
                chaqaloqlar--
                if (chaqaloqlar == 0) {
                    abHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    abHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                abHolatBinding.holatChaqaloqSoni.text = chaqaloqlar.toString()
            }
        }


    }
    private fun orqagaQaytish() {
        binding.orqagaQaytishAb.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }




}