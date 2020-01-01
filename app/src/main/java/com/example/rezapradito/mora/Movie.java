package com.example.rezapradito.mora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Movie extends AppCompatActivity {
    final DatabaseHelper dbHelper = new DatabaseHelper(this);
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Button button = (Button) findViewById(R.id.btnHome);
        ImageView showJumanji = (ImageView) findViewById(R.id.klikjumanji);
        showJumanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Jumanji.class);
                startActivity(intent);
            }
        });
        ImageView showFrozen = (ImageView) findViewById(R.id.klikfrozen);
        showFrozen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Frozen.class);
                startActivity(intent);
            }
        });
        ImageView showCa = (ImageView) findViewById(R.id.klikca);
        showCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Charlie.class);
                startActivity(intent);
            }
        });
        ImageView showIt = (ImageView) findViewById(R.id.klikit);
        showIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, ItChapter.class);
                startActivity(intent);
            }
        });
        ImageView showJoker = (ImageView) findViewById(R.id.klikjoker);
        showJoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Joker.class);
                startActivity(intent);
            }
        });
        ImageView showSpider = (ImageView) findViewById(R.id.klikspider);
        showSpider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Spider.class);
                startActivity(intent);
            }
        });
        ImageView showGM = (ImageView) findViewById(R.id.klikgm);
        showGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, GeminiMan.class);
                startActivity(intent);
            }
        });
        ImageView showDS = (ImageView) findViewById(R.id.klikds);
        showDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, DoctorSleep.class);
                startActivity(intent);
            }
        });
        ImageView showCR = (ImageView) findViewById(R.id.klikcr);
        showCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Movie.this, Crawl.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Movie.this,MainActivity.class);
                startActivity(i);
            }
        });
        Button movie = (Button) findViewById(R.id.btnHome);
        msg = (TextView) findViewById(R.id.textView);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = dbHelper.queryUsers(msg.getText().toString());
                Bundle mBundles = new Bundle();
                mBundles.putString("user", users.getEmail());
                Intent intents = new Intent(Movie.this, MainActivity.class);
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
                Intent intents = new Intent(Movie.this, akun.class);
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
                Intent intents = new Intent(Movie.this, LoginActivity.class);
                intents.putExtras(mBundles);
                startActivity(intents);
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            msg.setText(bundle.getString("user"));
        }
    }
}