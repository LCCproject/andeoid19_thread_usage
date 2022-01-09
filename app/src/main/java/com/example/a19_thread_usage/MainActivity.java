package com.example.a19_thread_usage;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btThread;

        btThread = findViewById(R.id.button_Thread);

        tvResult = findViewById(R.id.textView_Result);

        btThread.setOnClickListener(v -> {
            threadRun();
        });


    }//onCreate


    private void threadRun() {
        new Thread(() -> {
            for (int i = 1; i < 3; i++) {
                int count = i;

                runOnUiThread(() -> {
                    tvResult.setText(String.valueOf(count));
                });
                SystemClock.sleep(1000);
            }
            runOnUiThread(() -> {
                tvResult.setText("Got it");
            });
        }).start();
    }


}