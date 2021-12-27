package com.indianrail.android

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById<Button>(R.id.buttonLogin).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.buttonLogin) {
            finish()
        }
    }

}
