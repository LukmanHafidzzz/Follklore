package com.example.lol

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [user::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "user"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
    abstract fun userDao(): UserDao
}