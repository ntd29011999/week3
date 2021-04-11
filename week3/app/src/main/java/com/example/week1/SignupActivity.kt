package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val tvSigin = findViewById<TextView>(R.id.tvLogin)

        tvSigin.setOnClickListener {
            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(intent)
        }
    }
}