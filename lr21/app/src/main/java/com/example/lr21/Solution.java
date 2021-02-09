package com.example.lr21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Solution extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        EditText A = (EditText) findViewById(R.id.editTextTextPersonName6);
        EditText B = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText C = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText D = (EditText) findViewById(R.id.editTextTextPersonName8);
        TextView t = (TextView) findViewById(R.id.textView12);
        Button bb = (Button)findViewById(R.id.button7);

        String text = getIntent().getStringExtra("ans");

        t.setText(t.getText().toString() + "" + text);

        Button btn = (Button) findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solution.this, MainActivity.class);
                intent.putExtra("A", A.getText().toString());
                intent.putExtra("B", B.getText().toString());
                intent.putExtra("C", C.getText().toString());
                intent.putExtra("D", D.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solution.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
