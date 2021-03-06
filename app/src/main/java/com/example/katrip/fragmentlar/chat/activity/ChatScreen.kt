package com.example.katrip.fragmentlar.chat.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import com.example.katrip.R
import com.example.katrip.databinding.ActivityChatScreenBinding
import com.example.katrip.fragmentlar.chat.chatHaqida.ChatHaqida


class ChatScreen : AppCompatActivity() {
    lateinit var binding : ActivityChatScreenBinding
    var ovozliButton=true

    private val GALLERY_REQUEST = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
        fileTanlash()
        binding.fileJunatish.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,GALLERY_REQUEST)
        }
    }

    private fun fileTanlash() {

    }


    private fun chatYordamHaqida() {

        startActivity(Intent(this,ChatHaqida::class.java))

//        val alertDialog = AlertDialog.Builder(this,R.style.CustomAlertDialog)
//        val view = LayoutInflater.from(this).inflate(R.layout.diaolg_chat_yordam_haqida,null)
//        val dialogBinding = DiaolgChatYordamHaqidaBinding.bind(view)
//
//        alertDialog.setView(view)
//        dialogBinding.orqagaQaytish.setOnClickListener {
//            alertDialog.setOnDismissListener { dialog ->
//                dialog.dismiss()
//            }
//        }
//        alertDialog.show()
    }


    /*======================Teginma====================================================================*/



    private fun teginma() {
        chatdanChiqish()
        topButton1()
        xabarniKuzatish()
        window.statusBarColor= Color.WHITE
        topMenu()
    }


    private fun topMenu() {
        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.imageView5 -> {
                    showPopup(view)
                }
            }
        }
        binding.imageView5.setOnClickListener(clickListener)

    }


    @SuppressLint("RestrictedApi")
    private fun showPopup(view: View) {

        val menuBuilder = MenuBuilder(this)
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.chat_top_menu, menuBuilder)
        val optionsMenu = MenuPopupHelper(this, menuBuilder, view)
        optionsMenu.setForceShowIcon(true)
        menuBuilder.setCallback(object : MenuBuilder.Callback {
            override fun onMenuItemSelected(menu: MenuBuilder, item: MenuItem): Boolean {
                when(item.itemId)
                {
                    R.id.chat_xabar->{

                        true
                    }
                    R.id.chat_yordam_haqida ->{
                        chatYordamHaqida()
                        true
                    }
                    else -> false
                }
                return true
            }

            override fun onMenuModeChange(menu: MenuBuilder) {}
        })
        optionsMenu.show()

    }

    private fun xabarniKuzatish() {
        binding.matinliyXabar.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//              when(p0.toString().length)
//              {
//                  0->{
//                      D.d(p0.toString())
//                      binding.xabarJunatish.setImageResource(R.drawable.ic_chat_mikrafon)
//                  }
//                  else->{
//                      D.d(p0.toString())
//                      binding.xabarJunatish.setImageResource(R.drawable.ic_xabar_yuborish)
//                  }
//              }
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
    
    private fun topButton1() {
        binding.ovozliChatButton.setOnClickListener {
           when(ovozliButton)
           {
               true->
               {
                   binding.ovozliChatButton.setImageResource(R.drawable.ic_ovozli_chat_1)
                   ovozliButton=false
               }
               else->
               {
                   binding.ovozliChatButton.setImageResource(R.drawable.ic_ovozli_chat_2)
                   ovozliButton=true
               }
           }
        }
    }

    private fun chatdanChiqish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }



}