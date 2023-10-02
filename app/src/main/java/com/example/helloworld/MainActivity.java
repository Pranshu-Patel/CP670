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

    private Button tempButton;

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
        Log.i("resume","onResume");
    }


    protected void onPause() {
        super.onPause();
        Log.i("pause","onPause");
    }


    protected void onStart() {
        super.onStart();
        Log.i("start","onStart");
    }


    protected void onStop() {
        super.onStop();
        Log.i("stop","onStop");
    }


    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy","onDestroy");
    }
}