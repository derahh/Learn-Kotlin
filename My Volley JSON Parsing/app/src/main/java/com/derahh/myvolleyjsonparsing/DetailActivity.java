package com.derahh.myvolleyjsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.derahh.myvolleyjsonparsing.MainActivity.EXTRA_CREATOR;
import static com.derahh.myvolleyjsonparsing.MainActivity.EXTRA_LIKES;
import static com.derahh.myvolleyjsonparsing.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView tvCreator = findViewById(R.id.tv_creator_detail);
        TextView tvLikes = findViewById(R.id.tv_like_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        tvCreator.setText(creatorName);
        tvLikes.setText("Likes: "+likeCount);
    }
}
