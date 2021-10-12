package com.younghwani.summarize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;


public class InputActivity extends Activity {
    EditText edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edit = (EditText) findViewById(R.id.edit);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String input = edit.getText().toString();
                intent.putExtra("INPUT", input);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
