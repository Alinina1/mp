package com.example.lr5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public static int a;

    private MyThread thread;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int ANIMATION_TIME = 3_000;

    public long getTime() {
        return System.nanoTime() / 1_000_000;
    }

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        thread = new MyThread(getHolder(), this);
        setFocusable(true); // make sure we get key events

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas) {

        int w = canvas.getWidth();
        int h = canvas.getHeight();
        canvas.drawColor(Color.WHITE);

        long curTime = getTime() - 10;
        float fraction = (float) (curTime % ANIMATION_TIME) / ANIMATION_TIME;

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.GREEN);
        canvas.drawCircle(w * fraction + 10 * a, 600, 390 - 6 * a, paint);

        paint.setColor(Color.GRAY);
        canvas.drawCircle(w * fraction * a/3, w, 170 + 2 * a, paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(w * fraction * fraction * a, h * fraction, 120 - 4*a, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(400 * fraction, 200 * fraction * fraction, 60 * a/2, paint);

        paint.setColor(Color.RED);
        canvas.drawCircle(fraction * a * 2, h * fraction, 40 + 10 * a, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(w * fraction, w * fraction * fraction, 120, paint);
    }
}
