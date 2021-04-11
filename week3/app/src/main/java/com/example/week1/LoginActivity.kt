package com.example.week1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email=findViewById<EditText>(R.id.editTextTextPersonName2);
        val pass=findViewById<EditText>(R.id.editTextTextPassword);
        val btnLogin = findViewById<Button>(R.id.LoginButton)


        btnLogin.setOnClickListener {
            if(email.text.toString()=="ronaldo@gmail.com"&&pass.text.toString()=="123456")
            {
                //val intent: Intent =Intent(this@LoginActivity,ProfileActivity::class.java)
                //startActivity(intent)
                val inflater = layoutInflater
                val dLayout = inflater.inflate(R.layout.invalid_account_dialog,null)
                val loginDialog = AlertDialog.Builder(this)
                with(loginDialog){
                    setTitle("Account khong hop le")
                    setPositiveButton("OK"){_,_->}
                    setView(dLayout)
                    show()
           }
            }
        }
    }
}