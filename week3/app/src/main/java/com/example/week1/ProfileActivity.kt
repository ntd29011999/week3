package com.example.week1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.dialog.MaterialDialogs


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fullNameDescription = findViewById<TextView>(R.id.FullNameDescription)
        val emailDescription = findViewById<TextView>(R.id.EmailDescription)
        val phoneDescription = findViewById<TextView>(R.id.PhoneDescription)
        val editTextFullName = findViewById<ImageButton>(R.id.editTextFullName)
        val editTextEmail = findViewById<ImageButton>(R.id.editTextEmail)
        val editTextPhone = findViewById<ImageButton>(R.id.editTextPhoneNo)

       // editTextFullName.setOnClickListener {
        //    val dialogName = AlertDialog.Builder(this)

            //dialogName.apply{
           //     setTitle("Nhap Ho ten day du")
            //    EditText fn =
            //}
           // dialogName.setView(R.layout.dialog_full_name)
           // dialogName.setPositiveButton("OK",DialogInterface.OnClickListener({dialog, id -> }))
          // var editTextFullName = findViewById<EditText>(R.id.editDialogFullName)

           // dialogName.show()
       // }

        editTextFullName.setOnClickListener {
            val dialogName = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_full_name,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogFullName)

            with(dialogName){
                setTitle("Nhap Ho ten day du")
                setPositiveButton("OK"){dialog, which ->
                    fullNameDescription.text = editText.text.toString()
                }
               setView(dialogLayout)
            }
            dialogName.show()
        }





        editTextEmail.setOnClickListener {
            val dialogEmail = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_email,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogEmail)

            with(dialogEmail){
                setTitle("Nhap EMAIL")
                setPositiveButton("OK"){dialog, which ->
                    emailDescription.text = editText.text.toString()
                }
                setView(dialogLayout)
            }
            dialogEmail.show()
        }
        editTextPhone.setOnClickListener {
            val dialogName = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_phone,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogPhone)

            with(dialogName){
                setTitle("Nhap So dien thoai")
                setPositiveButton("OK"){dialog, which ->
                    phoneDescription.text = editText.text.toString()
                }
                setView(dialogLayout)
            }
            dialogName.show()
        }

    }
}


