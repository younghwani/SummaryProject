package com.younghwani.summarize;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                String input = data.getStringExtra("INPUT");
                String summarized = "호출 실패";
                // API 연동
                RestAPITask task = new RestAPITask();
                try {
                    summarized = task.execute(input).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                text.setText(summarized);
            }
        }
    }
}