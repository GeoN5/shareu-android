package com.example.appjam19.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R
import kotlinx.android.synthetic.main.activity_class_info.*
import kotlinx.android.synthetic.main.activity_my_tallent.fab

class ClassInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_info)

        fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:010-9524-9207")
            startActivity(intent)
        }

        accessButton.setOnClickListener {
            startActivity(Intent(this,CompleteActivity::class.java))
        }
    }
}
