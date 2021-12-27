package com.indianrail.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import module.ApplicationPrefs
import module.adapter.ContactListAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var recyclerViewContactList: RecyclerView
    private lateinit var imageViewLogout: ImageView
    private lateinit var imageViewUser: ImageView
    private lateinit var floatingActionButtonSearch: FloatingActionButton
    private lateinit var prefs: ApplicationPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = ApplicationPrefs(context = applicationContext)
        recyclerViewContactList = findViewById(R.id.recyclerViewContactList)
        imageViewLogout = findViewById(R.id.imageViewLogout)
        imageViewUser = findViewById(R.id.imageViewUser)
        floatingActionButtonSearch = findViewById(R.id.floatingActionButtonSearch)
        recyclerViewContactList.setHasFixedSize(true)
        recyclerViewContactList.layoutManager = LinearLayoutManager(this)
        recyclerViewContactList.adapter = ContactListAdapter()
        imageViewLogout.setOnClickListener(this)
        imageViewUser.setOnClickListener(this)
        floatingActionButtonSearch.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imageViewLogout -> {
                prefs.clearUser()
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
            R.id.imageViewUser -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.floatingActionButtonSearch -> {
                FilterDialog(this, this).show()
            }
        }
    }
}