package com.examples.fragments_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.btnFragment1)
        btnTwo = findViewById(R.id.btnFragment2)

        setFragments()




    }
    
    private fun setFragments(){
        //присвоить переменным экземпляры классов фрагментов
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        //установить по умолчанию фрагмент
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, secondFragment)
            commit()
        }
        //запуск первого фрагмента
        btnOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                commit()
            }
        }
        //запуск второго фрагмента
        btnTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                commit()
            }
        }
    }
    
}