package com.example.lab_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
    // Create a list of items
    String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);



        // Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Get a reference to the ListView and set the adapter
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
