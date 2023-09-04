package com.example.lol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login_Activity : AppCompatActivity() {

    lateinit var btnLogin : Button
    lateinit var tvSignup : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_Login)

        btnLogin.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

        tvSignup = findViewById(R.id.tv_Signup)

        tvSignup.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}