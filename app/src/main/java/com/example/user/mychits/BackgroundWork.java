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
/**
 * Created by user on 3/3/2018.
 */


public class BackgroundWork extends AsyncTask<String,String,String> {
        Context context;
        BackgroundWork(Context ctx){
            context=ctx;
        }
        @Override
    /*protected String doInBackground(String... params) {
        String url = "http://192.168.43.2/phpandroid/login.php";
        try {
            URL url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
        protected String doInBackground(String... params) {

            String reg_url="http://192.168.43.139/phpandroid/login.php";
            String method=params[0];
            if(method.equals("login"))
            {
                String etname=params[1];
                String etnumber=params[2];
                String etpost=params[3];
                String etaddress=params[4];
                try {
                    URL url=new URL(reg_url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os=httpURLConnection.getOutputStream();

                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                    String data= URLEncoder.encode("etname","UTF-8")+"="+URLEncoder.encode(etname,"UTF-8")+"&"+
                            URLEncoder.encode("etnumber","UTF-8")+"="+URLEncoder.encode(etnumber,"UTF-8")+"&"+
                            URLEncoder.encode("etpost","UTF-8")+"="+URLEncoder.encode(etpost,"UTF-8")+"&"+
                            URLEncoder.encode("etaddress","UTF-8")+"="+URLEncoder.encode(etaddress,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream IS=httpURLConnection.getInputStream();
                    IS.close();
                    return "Registration Successful";


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

    public void execute(String login, EditText etname, EditText etnumber, EditText etpost, EditText etaddress) {
    }
}


