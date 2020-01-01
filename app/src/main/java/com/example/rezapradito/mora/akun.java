package com.example.rezapradito.mora;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class akun extends AppCompatActivity {
    private TextView user;
    private EditText mViewPassword, mViewRepassword;
    private long id;
    final DatabaseHelper dbHelper = new DatabaseHelper(this);
    TextView msg;
    SQLiteDatabase db;

    Button Delete, Modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);
        db = openOrCreateDatabase("UserManager.db", Context.MODE_PRIVATE, null);
        user = (TextView) findViewById(R.id.user);
        mViewPassword = (EditText) findViewById(R.id.pw);
        mViewRepassword = (EditText) findViewById(R.id.repw);
        Delete = (Button) findViewById(R.id.btnDelete);
        Modify = (Button) findViewById(R.id.btnEdit);

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnDelete)
                {
//code for delete data
                    if(user.getText().toString().trim().length()==0)
                    {
                        msg(" Please enter Employee Name ");
                        return;
                    }
                    Cursor c=db.rawQuery("SELECT * FROM user WHERE user_email ='"+ user.getText()+"'", null);
                    if(c.moveToFirst())
                    {
                        db.execSQL("DELETE FROM user WHERE user_email ='"+ user.getText()+"'");
                        msg("Record Deleted");
                        Intent intent =  new Intent(akun.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        msg("Invalid Email ");
                    }
                }
            }
        });

        Modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v.getId()==R.id.btnEdit)
                {
//code for update data
                    if(user.getText().toString().trim().length()==0)
                    {
                        msg( "Enter Email");
                        return;
                    }
                    Cursor c=db.rawQuery("SELECT * FROM user WHERE user_email='"+ user.getText()+"'", null);
                    if(c.moveToFirst()) {
                        db.execSQL("UPDATE user SET user_password ='"+ mViewPassword.getText()+"' WHERE user_email ='"+user.getText()+"'");
                        msg( "Record Modified");
                        User users = dbHelper.queryUsers(user.getText().toString());
                        Bundle mBundles = new Bundle();
                        mBundles.putString("user", users.getEmail());
                        Intent intents = new Intent(akun.this, MainActivity.class);
                        intents.putExtras(mBundles);
                        startActivity(intents);
                    }

                    else
                    {
                        msg("Invalid Email");
                    }
                }
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            user.setText(bundle.getString("user"));
        }
    }


    public void msg( String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}


