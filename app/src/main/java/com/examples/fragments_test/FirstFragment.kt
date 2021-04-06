package com.examples.fragments_test


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class FirstFragment : Fragment(R.layout.fragment_first){


    override fun onStart() {
        super.onStart()

        val rect: ImageView? = activity?.findViewById(R.id.rectangle)
        val image1: ImageView? = activity?.findViewById(R.id.imageView1)
        val image3: ImageView? = activity?.findViewById(R.id.imageView3)

        rect?.setOnClickListener {
            rect.setBackgroundColor(Color.RED)
            val btnOne: Button? = activity?.findViewById(R.id.btnFragment1)
            btnOne?.setBackgroundColor(Color.RED)

            image1?.setBackgroundColor(Color.YELLOW)
            image3?.setBackgroundColor(Color.GREEN)
        }
    }
}