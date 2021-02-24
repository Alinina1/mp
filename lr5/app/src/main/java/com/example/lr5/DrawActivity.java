package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawPostcard(this));
    }

    class DrawPostcard extends View {

        Paint p;
        Rect rect;
        private final long  COLOR_ANIMATION  = 1_000;
        private ArgbEvaluator mArgbEvaluator; //класс для анимации смены цветов

        public DrawPostcard(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
            p.setColor(Color.RED);
            p.setStrokeWidth(10);
            mArgbEvaluator = new ArgbEvaluator();
        }

        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            colorAnimation(canvas);
            invalidate();
            super.onDraw(canvas);
            //canvas.drawARGB(80, 102, 204, 255); //фон заливка

            p.setTextSize(80);
            p.setTextAlign(Paint.Align.CENTER);

            canvas.drawText("С днём", 250, 100, p);
            canvas.drawText("защитника", 250, 300, p);
            canvas.drawText("Отчества!", 250, 500, p);

            canvas.drawLine(40,550,450,550,p);

            // рисуем круг с центром в (100,200), радиус = 50
            canvas.drawCircle(600, 675, 50, p);
            p.setStyle(Paint.Style.FILL);

            p.setColor(Color.rgb(255, 140, 0));
            canvas.drawRect(150, 600, 470, 650, p);
            p.setColor(Color.BLACK);
            canvas.drawRect(150, 650, 470, 700, p);
            p.setColor(Color.rgb(255, 140, 0));
            canvas.drawRect(150, 700, 470, 750, p);


        }
        private long getTime() { //возвращает текущее время в миллисекундах
            return System.nanoTime() / 1_000_000;
        }
        private void colorAnimation(Canvas canvas) {
            long curTime = getTime();
            float fraction = (float) (curTime % COLOR_ANIMATION) / COLOR_ANIMATION;

            if ((curTime / COLOR_ANIMATION) % 2 == 1)
                fraction = 1 - fraction;

            int color = (int) mArgbEvaluator.evaluate(fraction, Color.BLACK, Color.GREEN); //evaluate вычислаяет промежуточный цвет между двумя цветами
            //в зависимоти от fraction = [0, 1]
            canvas.drawColor(color);
        }
    }
}