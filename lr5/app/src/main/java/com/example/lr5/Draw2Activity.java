package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Draw2Activity extends AppCompatActivity {
    Paint p;

    SurfaceView sv;
    Canvas c;
    SurfaceHolder sh;
    boolean check = true;
    int x = 10;
    int y = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw2);

        sv = (SurfaceView) findViewById(R.id.surfaceView);
        sv.post(new Runnable() {
            @Override
            public void run() {
                if (sv.getHolder().getSurface().isValid()) {
                    Canvas canvas = sv.getHolder().lockCanvas();
                    clearCanvas(canvas);
                    if(check == true){
                        System.out.println("yes");
                        while(x<=700){
                            Toast.makeText(getApplicationContext(), "hello",Toast.LENGTH_SHORT).show();
                            drawAnimation(canvas);
                            //clearCanvas(canvas);
                            if (x >=1000 ){
                                x = 0;
                            }
                            else{
                                x+=100;
                            }
                            if (y >=3000){
                                y = 0;
                            }
                            else{
                                y+=100;
                            }
                           
                        }
                    }
                    sv.getHolder().unlockCanvasAndPost(canvas);
                }
            }
        });


        Button btn = (Button) findViewById(R.id.btn_anim);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = true;
            }
        });
    }

    private void drawColor(Canvas canvas, int color) {
        canvas.drawColor(color, PorterDuff.Mode.SRC);
    }

    private void clearCanvas(Canvas canvas) {
        drawColor(canvas, Color.RED);
    }

    private long getTime() {
        return System.nanoTime() / 1_000_000;
    }

    private void drawAnimation(Canvas canvas) {
        p = new Paint();
        p.setColor(Color.RED);

        canvas.drawCircle(x-100,y-100,50,p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(x,y,50,p);
    }

}