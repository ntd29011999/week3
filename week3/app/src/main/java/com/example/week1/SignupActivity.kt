package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import com.example.week1.databinding.ActivitySignupBinding
import android.widget.Toast
class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    lateinit var username: String
    lateinit var email: String
    lateinit var password:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding.LoginButton.setOnClickListener{
            username=binding.editTextTextPersonName2.toString().trim()
            email=binding.editTextTextPersonName2.toString().trim()
            password=binding.editTextTextPassword.toString().trim()

            if (email.isEmpty()) {
                binding.editTextTextPersonName2.error = "Please enter the email"
            }
            else if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Please enter the password"
            }
            else {
                Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }

        }

        binding.tvLogin.setOnClickListener{
            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(intent)
        }
    }

}