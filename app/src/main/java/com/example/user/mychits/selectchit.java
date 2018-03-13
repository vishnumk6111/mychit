package com.example.user.mychits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectchit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectchit);
        Button MYACCOUNT = (Button) findViewById(R.id.myaccount);
        Button createchit = (Button)findViewById(R.id.button7);
        MYACCOUNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubmit();

            }
        });
        createchit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myaccount();

            }
        });


    }

    public void opensubmit() {
        Intent create = new Intent(this, profile.class);
        startActivity(create);
    }

    public void myaccount() {
        Intent account = new Intent(this, createchit.class);
        startActivity(account);
    }
}