package com.example.cleaningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    companion object {
        var username = "wongtulus@amikom.ac.id"
        var password = "admin"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtUsername:EditText = findViewById(R.id.inputEmail)
        val txtPassword:EditText = findViewById(R.id.inputPassword)
        val btnLogin:Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            if (txtUsername.text.toString().equals(username)&&
                txtPassword.text.toString().equals(password)){
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Login Failed, Check your email and password",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}