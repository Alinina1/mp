package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button task1 = (Button) findViewById(R.id.button);
        Button task2 = (Button) findViewById(R.id.button2);
        Button task3 = (Button) findViewById(R.id.button3);
        Button task4 = (Button) findViewById(R.id.button4);
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Town.class);
                startActivity(intent);
            }
        });
    }
}