package com.example.user.mychits;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    int[] IMAGE = {R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a,};
    String[] NAMES = {"CHIT 1", "CHIT 2", "CHIT 3", "CHIT 4", "CHIT 5", "CHIT 6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        ListView listView = (ListView) findViewById(R.id.lvprofile);
        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);

    }

    public void createchit(){


    }
    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGE.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customchit,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.im1);
            EditText editText=(EditText) view.findViewById(R.id.editText5);
            imageView.setImageResource(IMAGE[i]);
            editText.setText(NAMES[i]);
            return view;
        }

    }





}

