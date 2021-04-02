package com.examples.fragments_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var btnOne: Button = findViewById(R.id.btnFragment1)
    var btnTwo: Button = findViewById(R.id.btnFragment1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    
    private fun buttonsClick(){
        btnOne.setOnClickListener {
            //запуск первого фрагмента

        }
    }
    
}