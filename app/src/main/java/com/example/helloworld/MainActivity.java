package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    String logText = "MainActivity :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button);

        Log.i(logText,"onCreate() encountered.");

    }

    public void clickHandler(View view) {
        Intent intent = new Intent(MainActivity.this,ListItemsActivity.class);
        startActivity(intent);
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