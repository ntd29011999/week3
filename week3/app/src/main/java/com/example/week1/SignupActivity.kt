package com.example.week1
import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.week1.databinding.ActivitySignupBinding
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignupViewModel
    private lateinit var viewModelFactory: SignupViewModelFactory
    lateinit var email: String
    lateinit var password: String
    lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        viewModelFactory = SignupViewModelFactory("bay","bay@gmail.com","123")
        viewModel= ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.apply {

            editTextTextPersonName.setOnClickListener {

                val username = editTextTextPersonName.text.toString().trim()
                viewModel.setAccountUserName(username)
            }
            editTextTextPersonName2.setOnClickListener {
                val email = editTextTextPersonName2.text.toString().trim()
                viewModel.setAccountUserName(email)
            }

            editTextTextPassword.setOnClickListener {
                val password = editTextTextPassword.text.toString().trim()
                viewModel.setAccountUserName(password)

            }
        }
            binding.LoginButton.setOnClickListener {
            if (email.isEmpty()) {
                binding.editTextTextPersonName2.error = "Please enter the email"
            } else if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Please enter the password"
            } else {

                Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()

            }

        }
        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {
            binding.editTextTextPersonName.setText(it.username)
            binding.editTextTextPersonName2.setText(it.email)
            binding.editTextTextPassword.setText(it.password)
        }  )
        binding.tvLogin.setOnClickListener{
            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(intent)
        }
    }


}