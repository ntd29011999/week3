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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        viewModelFactory = SignupViewModelFactory("bay","bay@gmail.com","123")
        viewModel= ViewModelProvider(this,viewModelFactory).get(SignupViewModel::class.java)
//        binding.apply {
//
//            editTextTextPersonName.setOnClickListener {
//                val username = editTextTextPersonName.text.toString().trim()
//                viewModel.setAccount(username)
//            }
//            editTextEmail.setOnClickListener {
//                val email = editTextEmail.text.toString().trim()
//                viewModel.setAccount(email)
//            }
//
//            editTextTextPassword.setOnClickListener {
//                val password = editTextTextPassword.text.toString().trim()
//                viewModel.setAccount(password)
//
//            }
//        }

        binding.LoginButton.setOnClickListener{
            if (binding.account?.username?.isEmpty() == true) {
                binding.editTextEmail.error = "Please enter the email"
            } else if (binding.account?.password?.isEmpty() == true) {
                binding.editTextTextPassword.error = "Please enter the password"
            } else {
                val username = binding.editTextTextPersonName.text.toString().trim()
                val email = binding.editTextEmail.text.toString().trim()
                val password = binding.editTextTextPassword.text.toString().trim()
                viewModel.setAccount(username,email,password)
                val intent = Intent(this@SignupActivity, SigninActivity::class.java)
                val bundle = Bundle()
                bundle.putString("username", binding.account?.username)
                bundle.putString("email", binding.account?.email)
                bundle.putString("password", binding.account?.password)
                intent.putExtras(bundle)
                startActivity(intent)

            }

        }
        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {
            binding.editTextTextPersonName.setText(it.username)
            binding.editTextEmail.setText(it.email)
            binding.editTextTextPassword.setText(it.password)
        }  )
    }


}