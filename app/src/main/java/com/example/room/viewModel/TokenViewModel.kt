package com.example.room.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.room.repository.TokenRepository
import com.example.room.rommDatabase.UserRoomDatabase
import com.example.room.roomEntity.TokenEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class TokenViewModel(application: Application): AndroidViewModel(application) {

    val readToken: LiveData<List<TokenEntity>>

    private val repositoriy: TokenRepository

    init {
        val userDao= UserRoomDatabase.getDatabase(application).tokenDao()
        repositoriy= TokenRepository(userDao)
        readToken=repositoriy.readAllData
    }
    fun insertToken(token:TokenEntity){
        viewModelScope.launch(Dispatchers.IO){
            try {
                repositoriy.insertToken(token)
            }catch (e:Exception){
                D.d(e.message.toString()+" <--> TokenViewModel insertToken funi")
            }
        }
    }

    fun deleteToken(){
        viewModelScope.launch {
            try {
                repositoriy.deleteToken()
            }catch (e:Exception){
                D.d(e.message.toString()+" <--> TokenViewModel deleteToken funi")
            }

        }
    }
}