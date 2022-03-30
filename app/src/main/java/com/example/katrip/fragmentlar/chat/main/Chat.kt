package com.example.katrip.fragmentlar.chat.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants.TEL

import com.example.katrip.databinding.FragmentChatBinding
import com.example.katrip.fragmentlar.chat.chatHaqida.ChatHaqida
import com.example.katrip.fragmentlar.chat.main.fireBase.adapter.ChatAdapter
import com.example.katrip.fragmentlar.chat.main.fireBase.endtity.ChatUser
import com.example.katrip.fragmentlar.chat.main.fireBase.viewModel.ChatViewModel
import com.example.log.D
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Chat : Fragment(),ChatAdapter.MessageSetOnClickListener {


    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private val userChatViewModel: ChatViewModel by lazy {
        ViewModelProviders.of(this).get(ChatViewModel::class.java)
    }
    private var messageArray: ArrayList<ChatUser> = arrayListOf()
    private lateinit var adapter:ChatAdapter
    private val GALLERY_REQUEST = 2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        chatHaqida()
        fileJunatish()
        setOnClickListener()
        userChatViewModel.readMessage(TEL)
        adapter = ChatAdapter(requireContext(),messageArray,this)
        readMessage()
        val view = binding.root
        return view
    }


    private fun setOnClickListener() {
        xabarJunatish()
    }

    private fun xabarJunatish() {
        binding.xabarJunatish.setOnClickListener {
            userChatViewModel.insertChatUser(
                ChatUser(
                    tel = TEL,
                    user = binding.matinliyXabar.text.toString()
                )
            )
            binding.matinliyXabar.text.clear()
        }
    }
    private fun readMessage() {
        binding.chatRecycler.adapter=adapter
        binding.chatRecycler.layoutManager= LinearLayoutManager(requireContext())
        userChatViewModel.message.observe(viewLifecycleOwner, Observer {
            messageArray.clear()
            it.forEach {
                messageArray.add(it)
            }
            adapter.notifyDataSetChanged()
            binding.chatRecycler.scrollToPosition(messageArray.size-1)
        })
    }

    private fun fileJunatish() {
        binding.fileJunatish.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,GALLERY_REQUEST)
        }
    }

    private fun chatHaqida() {
        binding.chatHaqida.setOnClickListener {
            startActivity(Intent(requireContext(),ChatHaqida::class.java))
        }
    }

    override fun listener(userChatAddEntity: String) {
        TODO("Not yet implemented")
    }


}