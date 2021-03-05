package com.example.lr5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Draw2 extends Activity {
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        Button buttonShowHide = (Button) findViewById(R.id.btn_animation);

        buttonShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                MySurfaceView.a = rand.nextInt(20);
                setContentView(R.layout.draw2);
            }
        });
    }
}