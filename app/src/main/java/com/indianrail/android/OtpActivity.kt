package com.indianrail.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.chaos.view.PinView
import module.ApplicationPrefs

class OtpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonVerifyOtp: Button
    private lateinit var imageViewBackArrow: ImageView
    private lateinit var prefs: ApplicationPrefs
    private lateinit var firstPinView: PinView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        prefs = ApplicationPrefs(applicationContext)
        buttonVerifyOtp = findViewById(R.id.buttonVerifyOtp)
        imageViewBackArrow = findViewById(R.id.imageViewBackArrow)
        firstPinView = findViewById(R.id.firstPinView)
        firstPinView.requestFocus()
        /*val inputMethodManager: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
            linearLayout.getApplicationWindowToken(),
            InputMethodManager.SHOW_FORCED, 0
        )*/
        buttonVerifyOtp.setOnClickListener(this)
        imageViewBackArrow.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonVerifyOtp -> {
                prefs.setUserId("1")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
            R.id.imageViewBackArrow -> {
                onBackPressed()
            }
        }
    }
}