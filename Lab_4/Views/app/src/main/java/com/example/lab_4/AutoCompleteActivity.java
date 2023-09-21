package com.example.lab_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.lab_4.R;

public class AutoCompleteActivity extends Activity {
    private AutoCompleteTextView autoCompleteTextView;
    private String[] countries = {
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia",
            // Add more countries as needed
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete_text_view);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // Create an ArrayAdapter with the country data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);

        // Set the adapter to the AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);
    }
}
