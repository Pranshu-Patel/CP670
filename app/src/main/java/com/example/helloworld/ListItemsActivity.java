package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 10;
    private ImageButton imageButton;
    private Switch switchButton;
    private CheckBox checkBox;
    String logText = "ListItemsActivity :";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        Log.i(logText,"onCreate() encountered");
        // Find the ImageButton view
        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


        switchButton = findViewById(R.id.switch1);
        print("Switch Button");
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String onSwitch = getString(R.string.onSwitch);
                String offSwitch = getString(R.string.offSwitch);
                String message = isChecked ? onSwitch : offSwitch;
                int duration = isChecked ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG;
                Toast.makeText(ListItemsActivity.this, message, duration).show();
            }
        });

        checkBox = findViewById(R.id.checkbox1);

        print("CheckBox");
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                    builder.setMessage(R.string.dialog_message)
                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", "Here is my response");
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    String clickedYesToast = getString(R.string.clickedYesToast);
                                    print(clickedYesToast);
                                    finish();
                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                    checkBox.setChecked(false);
                                }
                            })
                            .show();
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Get the image bitmap from the data Intent
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Set the image bitmap to the ImageButton
            imageButton.setImageBitmap(imageBitmap);

        }

        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");
            String toastMessage = "ListItemsActivity passed: " + messagePassed;
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public void print(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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

