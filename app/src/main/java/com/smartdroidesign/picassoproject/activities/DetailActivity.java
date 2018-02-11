package com.smartdroidesign.picassoproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.picassoproject.R;
import com.squareup.picasso.Picasso;

import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_CREATOR;
import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_LIKES;
import static com.smartdroidesign.picassoproject.activities.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView TextViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView TextViewLikes = findViewById(R.id.text_view_like_detail);

        Picasso.with(this)
                .load(imageUrl)
                .fit()
                .centerInside()
                .into(imageView);
        TextViewCreator.setText(creatorName);
        TextViewLikes.setText("Likes :" + likeCount);
    }
}
