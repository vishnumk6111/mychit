package com.example.user.mychits;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorkcreatechit extends AsyncTask<String,String,String> {
    Context context;
    BackgroundWorkcreatechit(Context ctx){
        context=ctx;
    }
    @Override
    /*protected String doInBackground(String... params) {
        String url = "http://192.168.43.2/phpandroid/chit.php";
        try {
            URL url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    protected String doInBackground(String... params) {

        String reg_url="http://192.168.43.139/phpandroid/chit.php";
        String method=params[0];
        if(method.equals("registration"))
        {
            String nm=params[1];
            String ettotalamount=params[2];
            String ettotalduration=params[3];
            String ettotalperiod=params[4];
            String etperiodpayment=params[5];
            String ettotalmembers=params[6];

            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("nm","UTF-8")+"="+URLEncoder.encode(nm,"UTF-8")+"&"+
                        URLEncoder.encode("ettotalamount","UTF-8")+"="+URLEncoder.encode(ettotalamount,"UTF-8")+"&"+
                        URLEncoder.encode("ettotalduration","UTF-8")+"="+URLEncoder.encode(ettotalduration,"UTF-8")+"&"+
                        URLEncoder.encode("ettotalperiod","UTF-8")+"="+URLEncoder.encode(ettotalperiod,"UTF-8")+"&"+
                        URLEncoder.encode("etperiodpayment","UTF-8")+"="+URLEncoder.encode(etperiodpayment,"UTF-8")+"&"+
                        URLEncoder.encode("ettotalmembers","UTF-8")+"="+URLEncoder.encode(ettotalmembers,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Successfull";


            } catch (MalformedURLException e) {
                return e.toString();
            } catch (IOException e) {
                return e.toString();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {

        //Toast.makeText(result,Toast.LENGTH_LONG).show();
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    public void execute(String nm, EditText ettotalamount, EditText ettotalduration, EditText ettotalperiod, EditText etperiodpayment, EditText ettotalmembers) {
    }
}

