package com.example.hm1m6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.hm1m6.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentValue = intent.getStringExtra("text")
        binding.tvTextview.setText( intentValue)



        binding.myButton.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("text", binding.tvTextview.text.toString()))
            finish()
        }
    }
}
