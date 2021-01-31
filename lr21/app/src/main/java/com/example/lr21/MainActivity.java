package com.example.lr21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button)findViewById(R.id.button);
        final EditText A = (EditText)findViewById(R.id.editTextTextPersonName2);
        final EditText B = (EditText)findViewById(R.id.editTextTextPersonName3);
        final EditText C = (EditText)findViewById(R.id.editTextTextPersonName4);
        final EditText D = (EditText)findViewById(R.id.editTextTextPersonName7);
        final TextView t = (TextView)findViewById(R.id.textView6);


        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aa, bb, cc, dd;
               String a = A.getText().toString();
                try {
                    Double a1 = new Double(a);
                    aa = a1;
                } catch (NumberFormatException e) {
                    t.setText("Введите все значения!");
                    return;
                }
                String b = B.getText().toString();
                try {
                    Double b1 = new Double(b);
                    bb = b1;
                } catch (NumberFormatException e) {
                    t.setText("Введите все значения!");
                    return;
                }
                String c = C.getText().toString();
                try {
                    Double c1 = new Double(c);
                    cc = c1;
                } catch (NumberFormatException e) {
                    t.setText("Введите все значения!");
                    return;
                }
                String d = D.getText().toString();
                try {
                    Double d1 = new Double(d);
                    dd = d1;
                } catch (NumberFormatException e) {
                    t.setText("Введите все значения!");
                    return;
                }
                if(aa < 0){
                    if(bb > 1){
                        t.setText("x > "+ Math.log((dd-cc)/aa)/Math.log(bb));
                    }
                    else if(bb < 1 && 0<bb){
                        t.setText("x < "+ Math.log((dd-cc)/aa)/Math.log(bb));
                    }
                }
                else if(aa > 0){
                    if(bb > 1){
                        t.setText("x < "+ Math.log((dd-cc)/aa)/Math.log(bb));
                    }
                    else if(bb < 1 && 0<bb){
                        t.setText("x > "+ Math.log((dd-cc)/aa)/Math.log(bb));
                    }
                }
                if (aa==0 || bb ==0 ){
                    if(cc<dd){
                        t.setText("Данное неравенство выполняется всегда");
                    }
                    else{
                        t.setText("Данное неравенство не имеет решения");
                    }
                }
                if(bb == 1){
                    if((aa+cc)<dd){
                        t.setText("Данное неравенство выполняется всегда");
                    }
                    else{
                        t.setText("Данное неравенство не имеет решения");
                    }
                }
            }
        });
    }
}