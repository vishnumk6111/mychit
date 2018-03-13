package com.example.user.mychits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class createchit extends AppCompatActivity {
    private Button submit;
    ImageButton imcreatechit;
    EditText etcname;
    EditText etttlamount;
    EditText ttlduration;
    EditText ttlperiod;
    EditText paymentdtls;
    EditText ttlmembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createchit);
        etcname =(EditText) findViewById(R.id.nm);
        etttlamount=(EditText)findViewById(R.id.ettotalamount);
        ttlduration=(EditText)findViewById(R.id.ettotalduration);
        ttlperiod=(EditText)findViewById(R.id.ettotalperiod);
        paymentdtls=(EditText)findViewById(R.id.etperiodpayment);
        ttlmembers=(EditText)findViewById(R.id.ettotalmembers);



        submit= (Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubmit();
            }
        });
    }
    public void opensubmit(){
        String t=etcname.getText().toString();
        String t2=etttlamount.getText().toString();
        String t3=ttlduration.getText().toString();
        String t4=ttlperiod.getText().toString();
        String t5=paymentdtls.getText().toString();
        String t6=ttlmembers.getText().toString();
        BackgroundWorkcreatechit bw = new BackgroundWorkcreatechit(createchit.this);
        bw.execute("registration",t,t2,t3,t4,t5,t6);
        finish();

        if (t.equals("")){
            Toast.makeText(this,"enter your chit name",Toast.LENGTH_LONG).show();
        }
        else if (t2.equals("")) {
            Toast.makeText(this, "please enter total amount", Toast.LENGTH_LONG).show();
        }
        else if (t3.equals("")) {
            Toast.makeText(this, "enter total duration", Toast.LENGTH_LONG).show();
        }
        else if (t4.equals("")) {
            Toast.makeText(this, "enter total no of period", Toast.LENGTH_LONG).show();
        }
        else if (t5.equals("")) {
            Toast.makeText(this, "enter period payment ", Toast.LENGTH_LONG).show();
        }
        else if (t6.equals("")) {
            Toast.makeText(this, "enter no of members", Toast.LENGTH_LONG).show();
        }
        else {
            Intent submit = new Intent(this, addmembers.class);
            startActivity(submit);
        }
    }
}
