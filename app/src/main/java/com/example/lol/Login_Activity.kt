package com.example.lol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class Login_Activity : AppCompatActivity() {

    lateinit var btnLogin : Button
    lateinit var etUsername : EditText
    lateinit var etPassword : EditText
    lateinit var tvSignup : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_login)


        btnLogin = findViewById(R.id.btn_Login)
        etUsername=findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        tvSignup = findViewById(R.id.tv_Signup)

        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                localLogin()
            }
        }

        tvSignup.setOnClickListener {
            val intent = Intent(this,NewsActivity::class.java)
            startActivity(intent)
        }
    }

    private suspend fun localLogin() {


        val db = AppDatabase.getDatabase(this)
        val dao = db?.userDao()
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val getUsername = dao?.getUsername(username).toString()
        val getPassword = dao?.getPassword(password).toString()


        if (dao?.login(username, password) == true) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_LONG)
                .show()
            }
        }
}