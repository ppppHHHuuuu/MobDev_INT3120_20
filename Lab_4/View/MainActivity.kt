package com.example.lab_4

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class MainActivity : Activity(),  OnItemSelectedListener{
    private var courses = arrayOf<String?>("C", "Python", "DSA", "OOP", "Drop School")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spin = findViewById<Spinner>(R.id.spinner)
        spin.onItemSelectedListener= this

        val arr: ArrayAdapter<*> = ArrayAdapter<Any?> (this, android.R.layout.simple_spinner_item, courses)
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.adapter = arr

    }

    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {
        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(applicationContext,
            courses[position],
            Toast.LENGTH_LONG)
            .show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext,
            "Abc",
            Toast.LENGTH_SHORT).show()
    }
}
