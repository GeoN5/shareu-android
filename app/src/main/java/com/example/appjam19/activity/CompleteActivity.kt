package com.example.appjam19.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R

class CompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        }, 1000)
    }
}
