package com.example.week1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week1.databinding.ActivityLoginBinding
import com.example.week1.databinding.ActivitySignupBinding
import java.util.*

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: SigninViewModel
    private lateinit var viewModelFactory: SigninViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val bundle = intent.extras
        var username: String =""
        var password: String =""
        bundle?.let{
            username = bundle.getString("email").toString().trim()
            password = bundle.getString("password").toString().trim()
        }
        viewModelFactory = SigninViewModelFactory("defaultname","defaultemail","defaultpassword")
        viewModel = ViewModelProvider(this,viewModelFactory).get(SigninViewModel::class.java)
        binding.account = viewModel.account.value
        viewModel.account.observe(this, androidx.lifecycle.Observer {
            binding.editTextEmail.setText(it.email)
            binding.editTextTextPassword.setText(it.password)
        })
        binding.textviewSU.setOnClickListener {
            val intent = Intent(this@SigninActivity, SignupActivity::class.java)
            startActivity(intent)
        }


        binding.LoginButton.setOnClickListener {
                var email = binding.editTextEmail.text.toString().trim()
                var password = binding.editTextTextPassword.text.toString().trim()
                if (email.equals(username) && password.equals(password)) {
                    val intent = Intent(this@SigninActivity, ProfileActivity::class.java)
                    startActivity(intent)
                } else {
                    val inflater = layoutInflater
                    val dLayout = inflater.inflate(R.layout.invalid_account_dialog, null)
                    val loginDialog = AlertDialog.Builder(this@SigninActivity)
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