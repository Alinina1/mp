package nutfullina.alina.lr7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import nutfullina.alina.lr7.room.TimetableDatabase;
import nutfullina.alina.lr7.room.TimetableEntity;

public class InsertActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button btnAdd;

    List<TimetableEntity> dataList = new ArrayList<>();
    TimetableDatabase timetableDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);
        editText3 = findViewById(R.id.edit_text3);
        btnAdd = findViewById(R.id.btn_add);

        timetableDatabase = TimetableDatabase.getInstance(this);
        dataList = timetableDatabase.mainDao().getAll();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InsertActivity.this, MainActivity.class);
                i.putExtra("line1", editText1.getText().toString().trim());
                i.putExtra("line2", editText2.getText().toString().trim());
                i.putExtra("line3", editText3.getText().toString().trim());
                startActivity(i);
                finish();
            }
        });
    }
}