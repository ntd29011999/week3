package com.example.week1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btnLogin = findViewById<Button>(R.id.LoginButton)
        val et_email_login = findViewById<EditText>(R.id.editTextTextPersonName2);
        val et_pass_login = findViewById<EditText>(R.id.editTextTextPassword);
        val tvSignup =findViewById<TextView>(R.id.tvSignUp)

        tvSignup.setOnClickListener {
            val intent = Intent(this@SigninActivity, SignupActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            if (et_email_login.text.toString() == "ronaldo@gmail.com" && et_pass_login.text.toString() == "123456") {
                val intent = Intent(this@SigninActivity, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                val inflater = layoutInflater
                val dLayout = inflater.inflate(R.layout.invalid_account_dialog, null)
                val loginDialog = AlertDialog.Builder(this)
                with(loginDialog) {
                    setTitle("")
                    setPositiveButton("OK") { _, _ -> }
                    setView(dLayout)
                    show()
                }

            }
        }
    }
}