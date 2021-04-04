package com.examples.fragments_test

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnSA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.btnFragment1)
        btnTwo = findViewById(R.id.btnFragment2)
        btnSA = findViewById(R.id.btnStartActivity)

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
            btnOne.visibility = View.INVISIBLE
            btnTwo.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }
        //запуск второго фрагмента
        btnTwo.setOnClickListener {
            btnOne.visibility = View.VISIBLE
            btnTwo.visibility = View.INVISIBLE
            supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
        //старт активити
        btnSA.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent, options.toBundle())
            finish()
        }
    }
    
}