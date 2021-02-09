package com.example.lr21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Bundle bundle = getIntent().getExtras();
        final Button b = (Button) findViewById(R.id.button);
        EditText A = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText B = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText C = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText D = (EditText) findViewById(R.id.editTextTextPersonName7);
        TextView t = (TextView) findViewById(R.id.textView6);
        Button back_button = (Button) findViewById(R.id.button6);

        String AA = getIntent().getStringExtra("A");
        String BB = getIntent().getStringExtra("B");
        String CC = getIntent().getStringExtra("C");
        String DD = getIntent().getStringExtra("D");

        A.setText(A.getText().toString() + "" + AA);
        B.setText(B.getText().toString() + "" + BB);
        C.setText(C.getText().toString() + "" + CC);
        D.setText(D.getText().toString() + "" + DD);

        b.setOnClickListener(new View.OnClickListener() {
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
                if (aa < 0) {
                    if (bb > 1) {
                        t.setText("x > " + Math.log((dd - cc) / aa) / Math.log(bb));
                    } else if (bb < 1 && 0 < bb) {
                        t.setText("x < " + Math.log((dd - cc) / aa) / Math.log(bb));
                    }
                } else if (aa > 0) {
                    if (bb > 1) {
                        t.setText("x < " + Math.log((dd - cc) / aa) / Math.log(bb));
                    } else if (bb < 1 && 0 < bb) {
                        t.setText("x > " + Math.log((dd - cc) / aa) / Math.log(bb));
                    }
                }
                if (aa == 0 || bb == 0) {
                    if (cc < dd) {
                        t.setText("Данное неравенство выполняется всегда");
                    } else {
                        t.setText("Данное неравенство не имеет решения");
                    }
                }
                if (bb == 1) {
                    if ((aa + cc) < dd) {
                        t.setText("Данное неравенство выполняется всегда");
                    } else {
                        t.setText("Данное неравенство не имеет решения");
                    }
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Solution.class);
                intent.putExtra("ans", t.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}