package com.indianrail.android

import `in`.galaxyofandroid.spinerdialog.SpinnerDialog
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class FilterDialog(context: Context, var activity: Activity) : Dialog(context, R.style.DBTheme),
    View.OnClickListener {
    private lateinit var editTextDesignation: EditText
    private lateinit var editTextGrade: EditText
    private lateinit var editTextZone: EditText
    private lateinit var editTextDivision: EditText
    private lateinit var editTextDepartment: EditText
    private var items: ArrayList<String> = ArrayList()
    private lateinit var spinnerDialog: SpinnerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_filter)
        setCancelable(false)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        initializeAllView()
    }

    private fun initializeAllView() {
        editTextDesignation = findViewById(R.id.editTextDesignation)
        editTextGrade = findViewById(R.id.editTextGrade)
        editTextZone = findViewById(R.id.editTextZone)
        editTextDivision = findViewById(R.id.editTextDivision)
        editTextDepartment = findViewById(R.id.editTextDepartment)
        items.add("Mumbai")
        items.add("Delhi")
        items.add("Bengaluru")
        items.add("Hyderabad")
        items.add("Ahmedabad")
        items.add("Chennai")
        items.add("Kolkata")
        items.add("Surat")
        items.add("Pune")
        items.add("Jaipur")
        items.add("Lucknow")
        items.add("Kanpur")
        findViewById<TextView>(R.id.textViewSearch).setOnClickListener { dismiss() }
        findViewById<ImageView>(R.id.imageViewClose).setOnClickListener { dismiss() }
        editTextDesignation.setOnClickListener(this)
        editTextGrade.setOnClickListener(this)
        editTextZone.setOnClickListener(this)
        editTextDivision.setOnClickListener(this)
        editTextDepartment.setOnClickListener(this)
    }

    private fun setSpinners(editText: EditText) {
        spinnerDialog = SpinnerDialog(
            activity,
            items,
            "Select or Search City",
            "Close"
        )
        spinnerDialog.setCancellable(true)
        spinnerDialog.setShowKeyboard(false)
        spinnerDialog.bindOnSpinerListener { item, position ->
            editText.setText(item)
        }
        spinnerDialog.showSpinerDialog()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.editTextDesignation -> {
                setSpinners(editTextDesignation)
            }
            R.id.editTextGrade -> {
                setSpinners(editTextGrade)
            }
            R.id.editTextZone -> {
                setSpinners(editTextZone)
            }
            R.id.editTextDivision -> {
                setSpinners(editTextDivision)
            }
            R.id.editTextDepartment -> {
                setSpinners(editTextDepartment)
            }
        }
    }
}
