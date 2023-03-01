package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    private lateinit var username : String
    private lateinit var tvData : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        checklogin()
        setupUI()
    }

    private fun init(){
        prefManager = PrefManager(this)
        username = prefManager.getUsername().toString()
        tvData = findViewById(R.id.tv_data)
    }
    private fun checklogin(){
        if(prefManager.isLogin() == false){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun setupUI(){
        tvData.text = "Hello $username"

    }

    fun clickLogout(view: View){
        prefManager.removeDate()
        val intent = Intent(this, LoginActivity::class.java)
        finish()

    }
}