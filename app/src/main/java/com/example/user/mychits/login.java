package com.example.user.mychits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class login extends AppCompatActivity {
    ImageButton imlogin;
    EditText etname;
    EditText etnumber;
    EditText etpost;
    EditText etaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etname=(EditText) findViewById(R.id.editText2);
        etnumber=(EditText) findViewById(R.id.editText);
        etpost=(EditText) findViewById(R.id.editText3);
        etaddress=(EditText) findViewById(R.id.editText4);

        Button SUBMIT = (Button) findViewById(R.id.button2);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubmit();
            }
        });
    }

    public void opensubmit() {
        String s = etname.getText().toString();
        String s2 = etnumber.getText().toString();
        String s3 = etaddress.getText().toString();
        String s4 = etpost.getText().toString();
        BackgroundWork w = new BackgroundWork (login.this);
        w.execute("login",s,s2,s3,s4);
        finish();

        if (s.equals("")) {
            Toast.makeText(this, "please enter your name", Toast.LENGTH_LONG).show();
        }
        else if (s2.equals("")) {

            Toast.makeText(this, "please enter your phone number", Toast.LENGTH_LONG).show();
        }
        else if (s3.equals("")) {

            Toast.makeText(this, "please enter your po", Toast.LENGTH_LONG).show();
        }
        else if (s4.equals("")) {

            Toast.makeText(this, "please enter your post", Toast.LENGTH_LONG).show();
        }
        else{

            Intent login = new Intent(this, selectchit.class);
            startActivity(login);
        }
    }
}