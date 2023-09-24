package com.example.lab_7;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonPhoneCall;
    TextView textFullName;

    EditText editTextFullname;

    Button buttonSendMessage;

    TextView textFeedback;

    EditText editTextFeedback;


    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK) {
                if (result.getData() != null && result.getData().getStringExtra("message") != null) {
                    textFeedback.setText(result.getData().getStringExtra("message"));
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFullName = findViewById(R.id.textName);
        editTextFullname = findViewById(R.id.editTextName);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        editTextFeedback= findViewById(R.id.editTextFeedBack);
        textFeedback = findViewById(R.id.textFeedBack);
        buttonPhoneCall = findViewById(R.id.buttonPhoneIntent);

        buttonPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:555-1234"));
                intentCall.setType("")
                startActivity(intentCall);
            }

        });

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String name = editTextFullname.getText().toString();
        String message = String.format("Hello, it is %s, message", name);
        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("message", message);
        startForResult.launch(intent);
    }

}