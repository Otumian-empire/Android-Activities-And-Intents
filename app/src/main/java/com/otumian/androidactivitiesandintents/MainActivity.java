package com.otumian.androidactivitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText messageInput;
    public static final String INTENT_MESSAGE_KEY = "INTENT_MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageInput = findViewById(R.id.message_et);
    }

    public void launchSecondActivity(View view) {
        String LOG_TAG = MainActivity.class.getSimpleName();
        Log.d(LOG_TAG, "Main button clicked");

        String text = messageInput.getText().toString();

        if (text.length() < 1) {
            Toast.makeText(this, "An input is required", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(INTENT_MESSAGE_KEY, text);
            startActivity(intent);
        }


    }
}