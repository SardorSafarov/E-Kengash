package com.example.room.rommDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.dao.UserDao
import com.example.room.roomEntity.UserEntity


@Database(entities = [UserEntity::class], version = 1)
abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun tokenDao(): UserDao

    companion object {
        @Volatile
        private var instance: UserRoomDatabase? = null

        fun getDatabase(context: Context):UserRoomDatabase
        {
            val tempInstance= instance
            if(tempInstance!=null)
            {
                return tempInstance
            }
            synchronized(this){
                val instancee= Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "user_database"
                ).build()
                instance=instancee
                return instancee
            }
        }

    }
}