package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    /*Button startChatButton = findViewById(R.id.chat_button);
    startChatButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(ACTIVITY_NAME, "User clicked Start Chat");
        }
    });*/

    String logText = "MainActivity :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button);

        Log.i(logText,"onCreate() encountered.");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Response", "My information to share");
        setResult(Activity.RESULT_OK, intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //String temp = "My information to share";
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");
            String toastMessage = "ListItemsActivity passed: " + messagePassed;
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }


    public void clickHandler_hello(View view) {
        Intent intent = new Intent(MainActivity.this,ListItemsActivity.class);
        startActivity(intent);
    }

    public void clickHandler_chat(View view) {
        //Intent intent = new Intent(MainActivity.this,);
        Log.i(logText, "User clicked Start Chat");
        Intent intent = new Intent(MainActivity.this, ChatWindow.class);
        startActivity(intent);
    }


    void onStartButtonClick()
    {
        Log.i(logText, "User clicked Start Chat");
    }

    protected void onResume() {
        super.onResume();
        Log.i(logText,"onResume() encountered.");
    }


    protected void onPause() {
        super.onPause();
        Log.i(logText,"onPause() encountered.");
    }


    protected void onStart() {
        super.onStart();
        Log.i(logText,"onStart() encountered.");
    }


    protected void onStop() {
        super.onStop();
        Log.i(logText,"onStop() encountered.");
    }


    protected void onDestroy() {
        super.onDestroy();
        Log.i(logText,"onDestroy() encountered.");
    }
}