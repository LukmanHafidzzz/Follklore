package com.example.lol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnSignUp : Button
    lateinit var tvLogin : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btn_signUp)

        btnSignUp.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

        tvLogin = findViewById(R.id.tv_Login)

        tvLogin.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }
    }
}