package com.example.eventra.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openDetailButton = findViewById<Button>(R.id.openDetailButton)

        openDetailButton.setOnClickListener {
            val intent = Intent(this, detail_hb::class.java)
            startActivity(intent)
        }
    }
}
