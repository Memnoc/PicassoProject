package com.smartdroidesign.picassoproject.activities;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdroidesign.picassoproject.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_CREATOR;
import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_LIKES;
import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        final ImageView imageView = findViewById(R.id.image_view_detail);
        TextView TextViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView TextViewLikes = findViewById(R.id.text_view_like_detail);
        Button setWallBtn = findViewById(R.id.setWallpaperBtn);

        Picasso.with(this)
                .load(imageUrl)
                .fit()
                .centerInside()
                .into(imageView);
        TextViewCreator.setText(creatorName);
        TextViewLikes.setText("Likes :" + likeCount);

        setWallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "CLICKED");
                WallpaperManager wallManager = WallpaperManager.getInstance(getApplicationContext());
                Bitmap bmpImg = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                try {
                    wallManager.setBitmap(bmpImg);
                    Toast.makeText(DetailActivity.this, "Wallpaper Set Successfully!!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(DetailActivity.this, "Setting WallPaper Failed!!", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

}
