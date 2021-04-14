package com.example.week1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel(username: String, email: String,password: String) : ViewModel() {
    var account : MutableLiveData<Account> = MutableLiveData()
    init {
        account.value = Account(username, email, password)
    }

    fun setAccountUserName(username: String){
        account.value?.username = username
        account.postValue(account.value)
    }
    fun setAccountEmail(email: String){


        account.value?.email = email
        account.postValue(account.value)
    }
    fun setAccountPassword(password: String){
        account.value?.password= password
        account.postValue(account.value)
    }

}
