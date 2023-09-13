package com.example.donationlayout

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.donationlayout.ui.theme.DonationLayoutTheme
import com.example.donationlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "ActivityMain"
    private lateinit var binding: ActivityMainBinding;
    private var totalAmount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val numberPicker = binding.numberPicker
        val txtUpdate = binding.exitTextAmount
        val progressBar = findViewById<ProgressBar>(R.id.progressBar1)
        val btnDonate = binding.btnDonate
        val txtTotal = binding.textTotal
        val addAmount = binding.exitTextAmount

        progressBar.visibility = View.VISIBLE

        numberPicker.minValue=1
        numberPicker.maxValue=100

        numberPicker.setOnValueChangedListener { _, _, _ ->
            progressBar.progress = numberPicker.value
        }
        btnDonate.setOnClickListener {
            totalAmount += Integer.parseInt(addAmount.text.toString())
            txtTotal.text = "Total amount is $totalAmount"
        }
    }
}
