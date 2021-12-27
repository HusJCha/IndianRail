package com.indianrail.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.buttonLogin -> {
                val intent = Intent(this, OtpActivity::class.java)
                startActivity(intent)
            }

        }
    }
}