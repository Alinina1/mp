package nutfullina.alina.lr7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import nutfullina.alina.lr7.room.TimetableDatabase;
import nutfullina.alina.lr7.room.TimetableEntity;

public class MainActivity extends Activity {

    List<TimetableEntity> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    TimetableDatabase timetableDatabase;
    MainAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit_text);
        RecyclerView rv = findViewById(R.id.rv);

        timetableDatabase = TimetableDatabase.getInstance(this);
        dataList = timetableDatabase.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, dataList);
        rv.setAdapter(adapter);

        String subject = "" + getIntent().getStringExtra("line1");
        String teacher = "" + getIntent().getStringExtra("line2");
        String cabinet = "" + getIntent().getStringExtra("line3");

        if (!subject.equals("null")) {
            TimetableEntity data = new TimetableEntity();

            data.setSubject(subject);
            data.setTeacher(teacher);
            data.setCabinet(cabinet);

            timetableDatabase.mainDao().insert(data);
            editText.setText("");

            dataList.clear();
            dataList.addAll(timetableDatabase.mainDao().getAll());
            adapter.notifyDataSetChanged();
        }

        //добавление
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(MainActivity.this, InsertActivity.class);
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Не удалось добавить", Toast.LENGTH_SHORT);
                }
            }
        });

        //поиск
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String search = "%" + editText.getText().toString().trim() + "%";
                    timetableDatabase.mainDao().getNamesLike(search);

                    dataList.clear();
                    dataList.addAll(timetableDatabase.mainDao().getNamesLike(search));
                    adapter.notifyDataSetChanged();

                    if (search.equals("")) {
                        dataList.clear();
                        dataList.addAll(timetableDatabase.mainDao().getAll());
                        adapter.notifyDataSetChanged();
                    }
                    handled = true;
                }
                return handled;
            }
        });
    }
}