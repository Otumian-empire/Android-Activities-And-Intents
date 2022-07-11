package com.otumian.androidactivitiesandintents;

import androidx.annotation.NonNull;
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
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageInput = findViewById(R.id.message_et);

        if (savedInstanceState != null) {
            String text = savedInstanceState.get(INTENT_MESSAGE_KEY).toString();

            messageInput.setText(text);
        }

        Log.d(LOG_TAG, "-----------------");
        Log.d(LOG_TAG, "onCreate Callback");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart callback");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume callback");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause callback");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop callback");
    }

    // this method is called between the onPause and onStop to save the state of this instance
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String text = messageInput.getText().toString();
        outState.putString(INTENT_MESSAGE_KEY, text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy callback");
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