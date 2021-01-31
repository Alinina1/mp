package com.example.lr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton r1 = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton r2 = (RadioButton)findViewById(R.id.radioButton2);
        final RadioGroup r = (RadioGroup)findViewById(R.id.radioGroup);
        final Button b = (Button)findViewById(R.id.button);
        final TextView t = (TextView)findViewById(R.id.textView2);

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked()) t.setText("да");
                if (r2.isChecked()) t.setText("нет");

            }
        });
    }
}