package com.example.room.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.room.repository.UserRepository
import com.example.room.rommDatabase.UserRoomDatabase
import com.example.room.roomEntity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class UserViewModel(application: Application): AndroidViewModel(application) {

    val readUser: LiveData<List<UserEntity>>

    private val repositoriy: UserRepository

    init {
        val userDao= UserRoomDatabase.getDatabase(application).tokenDao()
        repositoriy= UserRepository(userDao)
        readUser=repositoriy.readAllData
    }
    fun insertUser(user:UserEntity){
        viewModelScope.launch(Dispatchers.IO){
            try {
                repositoriy.insertUser(user)
            }catch (e:Exception){
                D.d(e.message.toString()+" <--> TokenViewModel insertToken funi")
            }
        }
    }

    fun deleteToken(){
        viewModelScope.launch {
            try {
                repositoriy.deleteUser()
            }catch (e:Exception){
                D.d(e.message.toString()+" <--> TokenViewModel deleteToken funi")
            }

        }
    }
}