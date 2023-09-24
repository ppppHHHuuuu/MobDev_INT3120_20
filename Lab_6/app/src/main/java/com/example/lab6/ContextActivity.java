package com.example.lab6;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

public class ContextActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_layout);
        button = (Button) findViewById(R.id.buttonLongPress);
        this.registerForContextMenu(this.button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemUpload) {
            Toast.makeText(this, "This is message for item Upload", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.itemBookmark) {
            Toast.makeText(this, "This is message for item bookmark", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "This is message for item Share", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}
