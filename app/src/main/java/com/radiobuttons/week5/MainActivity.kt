package com.radiobuttons.week5

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<TextView>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        //focus on Name on load
        txtName.requestFocus()
        btnSubmit.setOnClickListener {
            if (rbMale.isChecked) txtShow.text = "Hello,  ${txtName.text}, the mens lounge is on the second floor. We will " +
                    "send an email of meeting agenda to your email : ${txtEmail.text}"
            if (rbFemale.isChecked) txtShow.text = "Hello  ${txtName.text}, the womens lounge is on the first floor. We will " +
                    "send an email of meeting agenda to your email : ${txtEmail.text}"
            hideKeyboard()
            txtName.setText("")
            txtEmail.setText("")
            txtName.requestFocus()
        }
    }
    // function to hide keyboard goes right before the last right bracket of Class MainActivity
    //import android.content.Context
    //import android.view.inputmethod.InputMethodManager
    private fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}
