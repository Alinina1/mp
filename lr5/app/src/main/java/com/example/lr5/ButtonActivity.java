package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    int n = 1;
    Button numb, sum_int;
    long f = 0;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        numb = (Button)findViewById(R.id.button);
        sum_int = (Button)findViewById(R.id.button_sum);

        numb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),""+n++, Toast.LENGTH_SHORT).show();
            }
        });
        sum_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable(){
                    public void run(){
                        Log.i("process_thread","beginning...");

                        for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f+=i++);
                        /*
                        так нельзя:
                        sum_int.setText("Готово! \n" + f);
                        */
                        OutRez outRez = new OutRez();
                        outRez.execute();
                        Log.i("process_thread","Резкльтат вычисления: " + f);
                    }
                };
                Thread thread = new Thread(runnable);
                Log.i("process_thread","start");
                thread.start();
                Log.i("process_thread","end");
            }
        });
    }

    class OutRez extends AsyncTask<Void, Void, Long>{

        @Override
        protected Long doInBackground(Void... voids) {
            return f;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Long aLong) {
            //super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(),"Готово!\n" + aLong,Toast.LENGTH_LONG ).show();
        }
    }
}