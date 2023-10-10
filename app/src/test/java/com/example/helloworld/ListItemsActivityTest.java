package com.example.helloworld;

import static org.junit.Assert.*;

import android.content.Intent;
import android.provider.MediaStore;
import android.widget.ImageButton;

import org.junit.Test;

public class ListItemsActivityTest {

    @Test
    public void onCreate() {
    }

    @Test
    public void testOnClick() {
        ListItemsActivity activity = new ListItemsActivity();
        ImageButton imageButton = activity.findViewById(R.id.imageButton);
        imageButton.performClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertEquals(MediaStore.ACTION_IMAGE_CAPTURE, startedIntent.getAction());
    }
    @Test
    public void onActivityResult() {
    }

    @Test
    public void print() {
    }

    @Test
    public void onResume() {
    }

    @Test
    public void onPause() {
    }

    @Test
    public void onStart() {
    }

    @Test
    public void onStop() {
    }

    @Test
    public void onDestroy() {
    }
}