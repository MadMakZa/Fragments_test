package com.examples.fragments_test


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class FirstFragment : Fragment(R.layout.fragment_first){


    override fun onStart() {
        var rect: ImageView? = activity?.findViewById(R.id.rectangle)
        rect?.setOnClickListener {
            rect.setBackgroundColor(Color.RED)
        }
        super.onStart()
    }
}