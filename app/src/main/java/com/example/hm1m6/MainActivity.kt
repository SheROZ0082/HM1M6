package com.example.hm1m6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import com.example.hm1m6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var ui: ActivityMainBinding
    private  var launch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            ui.etOne.setText(it.data?.getStringExtra("text"))
        }
    }
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        editText = findViewById(R.id.et_one)

        initListeners()



    }

    private fun initListeners() {

        ui.myButton.setOnClickListener {
            if(ui.etOne.text.isNotEmpty()){
                launch.launch(Intent(this, MainActivity2::class.java).apply {
                    putExtra("text", ui.etOne.text.toString())
                })
            }else{
                Toast.makeText(this, "Поле не должно быть пустым",Toast.LENGTH_SHORT).show()
            }
        }

    }
}