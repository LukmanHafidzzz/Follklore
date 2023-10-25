package com.example.lol

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<user>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<user>

    @Query("SELECT * FROM user WHERE username LIKE :first LIMIT 1")
    suspend fun findByName(first: String): user

    @Insert
    suspend fun insertAll(users: user)

    @Delete
    suspend fun delete(user: user)

    @Query("SELECT username from user where username=:username")
    suspend fun getUsername(username: String): String

    @Query("SELECT password from user where password=:password")
    suspend fun getPassword(password:String): String

    @Query("SELECT EXISTS(SELECT*FROM user where username=:username AND password=:password)")
    suspend fun login(username: String, password: String):Boolean
}