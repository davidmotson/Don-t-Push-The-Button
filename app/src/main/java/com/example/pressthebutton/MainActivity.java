package com.example.pressthebutton;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button crashButton = findViewById(R.id.badbutton);
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showToast("Oh NO!");

                // Crash after displaying the Toast message
                crashAfterDelay(2000);
            }
        });
    }

    private void showToast(String msg) {
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void crashAfterDelay(int delayInMs) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        }, delayInMs);

    }
}

