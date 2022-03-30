package com.example.katrip.fragmentlar.chat.main.fireBase.viewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.katrip.fragmentlar.chat.main.fireBase.endtity.ChatUser
import com.example.log.D
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatViewModel : ViewModel() {


    private val _messsage = MutableLiveData<List<ChatUser>>()
    val message: LiveData<List<ChatUser>>
        get() = _messsage

    val user =  FirebaseDatabase.getInstance().getReference("USERS")

    fun insertChatUser(userChatAddEntity: ChatUser) {
        user.child(userChatAddEntity.tel.toString()).setValue(userChatAddEntity.tel)

        val messageDb =
            FirebaseDatabase.getInstance().getReference("CHAT${userChatAddEntity.tel}")


        messageDb.
        child(messageDb.push().key.toString()).
        setValue(userChatAddEntity)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("sardor", "qo`shildi")
                } else {
                    Log.d("sardor", "nimadir bo`ldiii")
                }
            }
    }

    fun readMessage(readUser: String) {
        val messageDb =
            FirebaseDatabase.getInstance().getReference("CHAT${readUser}")
        D.d(readUser)
        messageDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    val items = mutableListOf<ChatUser>()
                    p0.children.forEach {
                        D.d(it.toString())
                        val item = it.getValue(ChatUser::class.java)
                        item?.tel = it.key
                        item.let {
                            if (it != null) {
                                items.add(it)
                            }
                        }
                    }
                    _messsage.value = items
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


}