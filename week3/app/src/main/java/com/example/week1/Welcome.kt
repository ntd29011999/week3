package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val tv = findViewById<TextView>(R.id.tvEmailPhone)

        tv.setOnClickListener {
            val intent = Intent(this@Welcome, SigninActivity::class.java)
            startActivity(intent)
        }
    }
}