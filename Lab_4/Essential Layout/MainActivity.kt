package com.example.essentialsofdevelopmentandroid

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.essentialsofdevelopmentandroid.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var nameInput: EditText
    private lateinit var phoneNumberInput: EditText
    private lateinit var groceriesOutput:EditText
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        nameInput = binding.nameInput
        phoneNumberInput = binding.phoneNumberInput
        groceriesOutput = binding.groceriesListOutput
        val cheeseSelection = binding.cheeseBtn
        val doubleCheeseSelection = binding.doubleCheeseBtn
        val noneSelection = binding.noneBtn
        val squareSelection = binding.squareBtn
        val roundSelection = binding.roundBtn
        val pepperoniSelection = binding.pepperoniBtn
        val mushroomSelection = binding.mushroomBtn
        val veggiesSelection = binding.veggiesBtn
        defaultOutputText()
        nameInput.addTextChangedListener(textWatcher);
        phoneNumberInput.addTextChangedListener(textWatcher);
    }
    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

        }
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            updateOutputText()
        }
        override fun afterTextChanged(editable: Editable) {}
    }
    private fun defaultOutputText() {
        val outputText = "Name: \nPhone: "
        groceriesOutput.setText(outputText)
    }
    private fun updateOutputText(){
        val name: String = nameInput.text.toString()
        val phoneNumber: String = phoneNumberInput.text.toString()

        val outputText =
            "Name: $name\nPhone: $phoneNumber"
        groceriesOutput.setText(outputText)
    }
}
