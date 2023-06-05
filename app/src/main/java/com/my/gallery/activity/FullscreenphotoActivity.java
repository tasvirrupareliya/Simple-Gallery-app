package com.my.gallery.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.my.gallery.R;

public class FullscreenphotoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        imageView = (ImageView) findViewById(R.id.full_screenshow);

        Intent intent = getIntent();
        String photos = intent.getStringExtra("photolist");

        Glide.with(this).load(photos).into(imageView);
    }
}