package com.example.appjam19.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R
import kotlinx.android.synthetic.main.activity_class_detail.*

class ClassDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_detail)

        classButton.setOnClickListener {
            startActivity(Intent(this,CompleteActivity::class.java))
        }

        second.setOnClickListener {
            startActivity(Intent(this,ClassInfoActivity::class.java))
        }

    }
}
