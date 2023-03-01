package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var username: String
    private lateinit var password: String

    // DATA Validation
    private var validUsername = "anusrest"
    private var validPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        checkLogin()
    }

    private fun init(){
        prefManager = PrefManager(this)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
    }

    private fun checkLogin(){
        if(prefManager.isLogin()!!){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun clickLogin(view : View){
        username = etUsername.text.toString().trim()
        password = etPassword.text.toString().trim()

        if (username.isEmpty() || username == ""){
            etUsername.error = "Username is Empty"
            etUsername.requestFocus()
        }else if(password.isEmpty() || password == ""){
            etPassword.error = "Password is Empty"
            etPassword.requestFocus()
        }else if (username != validUsername){
            etUsername.error = "Username not correct"
            etUsername.requestFocus()
        }else if (password != validPassword){
            etPassword.error = "Password not correct"
            etPassword.requestFocus()
        }else{
            prefManager.setLogin(true)
            prefManager.setUsername(username)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        }
}