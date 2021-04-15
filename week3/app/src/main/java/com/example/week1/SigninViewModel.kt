package com.example.week1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SigninViewModel(username: String, email: String,password: String) : ViewModel()  {
    var account : MutableLiveData<Account> = MutableLiveData()
    init {
        account.value = Account(username, email, password)
    }

    fun setAccount(username: String,email: String,password: String){
        account.value?.username = username
        account.postValue(account.value)
        account.value?.email = email
        account.postValue(account.value)
        account.value?.password= password
        account.postValue(account.value)
    }

}