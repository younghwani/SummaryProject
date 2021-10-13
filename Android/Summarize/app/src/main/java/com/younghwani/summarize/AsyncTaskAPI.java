package com.younghwani.summarize;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskAPI extends AsyncTask<String, Void, String> {
    private String result;
    protected String mInput;

    @Override
    protected String doInBackground(String... params) {
        String input = params[0];
        mInput = input;
        try {
            URL url = new URL("http://localhost:8080/api/summary?text=" + input);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader reader = new BufferedReader(isr);
                StringBuffer buffer = new StringBuffer();

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                result = buffer.toString();
                Log.i("Result : ", result);

                reader.close();
            } else {
                Log.d("GET 결과 : ", conn.getResponseCode() + " Error");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return "Unable to retreive data. URL may be invalid.\n" + mInput;
        }

        return result;
    }
}
