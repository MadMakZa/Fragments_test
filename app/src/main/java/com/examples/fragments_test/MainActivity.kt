package com.examples.fragments_test

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnSA: Button
    private lateinit var btnColor: Button

    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.btnFragment1)
        btnTwo = findViewById(R.id.btnFragment2)
        btnSA = findViewById(R.id.btnStartActivity)
        btnColor = findViewById(R.id.btnChangeColor)
        image1 = findViewById(R.id.id_rectangle)
        image2 = findViewById(R.id.imageView1)
        image3 = findViewById(R.id.imageView2)
        image4 = findViewById(R.id.imageView3)
        image5 = findViewById(R.id.imageView4)

        setFragments()
        changeColor()




    }
    //сменить цвет вьюх во фрагментах
    private fun changeColor(){
        var flag = false
        btnColor.setOnClickListener {
            if(flag) {
                image1.setImageResource(R.color.red)
                image2.setImageResource(R.color.red)
                image3.setImageResource(R.color.red)
                image4.setImageResource(R.color.red)
                image5.setImageResource(R.color.red)
                flag = true
            }
            if(!flag) {
                image1.setImageResource(R.color.orange)
                image2.setImageResource(R.color.orange)
                image3.setImageResource(R.color.orange)
                image4.setImageResource(R.color.orange)
                image5.setImageResource(R.color.orange)
                flag = false
            }
        }
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