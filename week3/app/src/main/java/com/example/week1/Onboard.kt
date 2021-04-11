package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class Onboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_onboard)
        val btn = findViewById<ImageButton>(R.id.btn)

        btn.setOnClickListener{
            val intent = Intent(this@Onboard, Welcome::class.java)
            startActivity(intent)

        }


    }
}