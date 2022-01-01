package com.younghwani.summarize;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
    private final String TAG = getClass().getSimpleName();
    private final String BASE_URL = "http://10.0.2.2:8080";
    private RetrofitAPI retrofitAPI;
    TextView text;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(in, GET_STRING);
            }
        });

        initSummaryAPI(BASE_URL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text.setText("요약 중입니다. 잠시만 기다려주세요!");
                String input = data.getStringExtra("INPUT");
                Log.d(TAG,"GET");
//                Call<SummaryItem> getCall = retrofitAPI.get_summary(input);
                Call<SummaryItem> getCall = retrofitAPI.get_kobart_sum(input);
//                Log.d("Check", getCall.request().url().toString());
                getCall.enqueue(new Callback<SummaryItem>() {
                    @Override
                    public void onResponse(Call<SummaryItem> call, Response<SummaryItem> response) {
                        if( response.isSuccessful()){
                            SummaryItem item = response.body();
                            String output = item.getOutput();
                            Log.d("Check", "Summary : " + output);
                            text.setText(output);
                        }else {
                            text.setText("요약에 실패했습니다. 다시 시도해주세요!");
                            Log.d(TAG,"Status Code : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<SummaryItem> call, Throwable t) {
                        text.setText("요약에 실패했습니다. 다시 시도해주세요!");
                        Log.d(TAG,"Fail msg : " + t.getMessage());
                    }
                });

            }
        }
    }

    private void initSummaryAPI(String baseUrl) {
        Log.d(TAG, "initSummaryAPI : " + baseUrl);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }
}