package com.example.lab6;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity {


    Button btnCheckMe;
    Button btnPopupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_layout);

        this.btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu1);
        this.btnCheckMe = (Button) findViewById(R.id.btnCheckMe);

        this.btnCheckMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCheckMeClicked();
            }
        });
    }

    private void btnCheckMeClicked() {
        Log.d("CHECK ME CLIKED", "ABC");
        PopupMenu popup = new PopupMenu(this, this.btnPopupMenu);
        popup.inflate(R.menu.popup_menu);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                Toast.makeText(PopupActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }
}
