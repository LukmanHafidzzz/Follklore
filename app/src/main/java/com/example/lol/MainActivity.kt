package com.example.lol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var btnSignUp : Button
    lateinit var etName : EditText
    lateinit var etUsername : EditText
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var etConfirmPassword : EditText
    lateinit var tvLogin : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btn_signUp)
        etName = findViewById(R.id.etName)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        tvLogin = findViewById(R.id.tv_Login)

        btnSignUp.setOnClickListener {
            lifecycleScope.launch {
                register()
            }
        }

        tvLogin.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

    }

    suspend fun register() {

        var name = etName.text.toString()
        var username = etUsername.text.toString()
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var confirmPassword = etConfirmPassword.text.toString()

        val user = user(0,name, username, email, password)
        val db = AppDatabase.getDatabase(this)
        val dao = db?.userDao()
        dao?.insertAll(user)

    }
}