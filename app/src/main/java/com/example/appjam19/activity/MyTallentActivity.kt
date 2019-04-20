package com.example.appjam19.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R
import kotlinx.android.synthetic.main.activity_my_tallent.*

class MyTallentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tallent)

        fab.setOnClickListener {
            startActivity(Intent(this,RegisterTallentActivity::class.java))
        }
    }

}
