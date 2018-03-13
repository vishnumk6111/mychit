package com.example.user.mychits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addmembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmembers);
        Button add = (Button) findViewById(R.id.btnaddmembers);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openadd();
            }
        });
    }

    public void openadd(){
        Intent navigate = new Intent(this, chitty1.class);
        startActivity(navigate);
    }
}
