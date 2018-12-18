package com.akj.lotto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        Toast.makeText(applicationContext, "NameActivity 입니다.", Toast.LENGTH_LONG).show()
    }
}
