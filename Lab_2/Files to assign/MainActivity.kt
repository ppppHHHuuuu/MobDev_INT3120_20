package com.example.statedemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.statedemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val TAG = "ActivityMain"
    private lateinit var binding: ActivityMainBinding;
    private var totalAmount = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val numberPicker = binding.dialogNumberPicker
        val txtUpdate = binding.txtUpdate
        val progressBar = findViewById<ProgressBar>(R.id.progressBar1)
        val btnDonate = binding.btnDonate
        val txtTotal = binding.txtTotalAmount
        val addAmount = binding.addAmount

        progressBar.visibility = View.VISIBLE

        numberPicker.minValue=1
        numberPicker.maxValue=100

        numberPicker.setOnValueChangedListener { _, _, _ ->
            txtUpdate.text = "Selected " + numberPicker.value
            progressBar.progress = numberPicker.value
        }
        btnDonate.setOnClickListener {
            totalAmount += Integer.parseInt(addAmount.text.toString())
            txtTotal.text = "Total amount is $totalAmount"
        }
    }
}
