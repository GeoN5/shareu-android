package com.example.appjam19.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R
import kotlinx.android.synthetic.main.activity_introduce.*

class IntroduceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)

        loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}
