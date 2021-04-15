package com.example.week1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SigninViewModelFactory(val username: String, val email: String, val password: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SigninViewModel::class.java)) {
            return SigninViewModel(username, email, password) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}