package com.example.rezapradito.mora;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

public class Jumanji extends AppCompatActivity {
    private AppCompatRatingBar RatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumanji);
        final TextView getRating = findViewById(R.id.rate);

        RatingBar = findViewById(R.id.penilaian);
        RatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(android.widget.RatingBar ratingBar, float nilai, boolean b) {

                getRating.setText("Rating: "+nilai);
            }
        });

    }
}
