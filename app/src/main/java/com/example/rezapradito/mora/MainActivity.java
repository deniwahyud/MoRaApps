package com.example.rezapradito.mora;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};
    final DatabaseHelper dbHelper = new DatabaseHelper(this);
    TextView msg;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        Button movie = (Button) findViewById(R.id.btnMovie);
        msg = (TextView) findViewById(R.id.textView);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = dbHelper.queryUsers(msg.getText().toString());
                Bundle mBundles = new Bundle();
                mBundles.putString("user", users.getEmail());
                Intent intents = new Intent(MainActivity.this, Movie.class);
                intents.putExtras(mBundles);
                startActivity(intents);
            }
        });
        Button about = (Button) findViewById(R.id.btnAccount);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = dbHelper.queryUsers(msg.getText().toString());
                Bundle mBundles = new Bundle();
                mBundles.putString("user", users.getEmail());
                Intent intents = new Intent(MainActivity.this, akun.class);
                intents.putExtras(mBundles);
                startActivity(intents);
            }
        });

        Button logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = dbHelper.queryUsers(msg.getText().toString());
                Bundle mBundles = new Bundle();
                mBundles.putString("user", users.getEmail());
                Intent intents = new Intent(MainActivity.this, LoginActivity.class);
                intents.putExtras(mBundles);
                startActivity(intents);
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            msg.setText(bundle.getString("user"));
        }

    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };



}
