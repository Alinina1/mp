package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Create");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "RestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.v("tag", "RestoreInstanceState");
    }
    // Вызывается, когда активность стала видимой
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Start");
// Проделать необходимые действия для активности, видимой на экране
    }
    // Должен вызываться в начале видимого состояния.
// На самом деле Android вызывает данный обработчик только
// для активностей, восстановленных из неактивного состояния
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Resume");
// Восстановить приостановленные обновления UI,
// потоки и процессы, приостановленные, когда
// активность была в неактивном состоянии
    }
    // Вызывается перед выходом из активного состояния,
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(this, "SaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.v("tag", "SaveInstanceState");
    }
    // Вызывается перед выходом из активного состояния
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Pause");
// Приостановить обновления UI, потоки или трудоемкие процессы,
// ненужные, когда активность не на переднем плане
    }
// Вызывается перед выходом из видимого состояния
    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Stop");
// Приостановить обновления UI, потоки ненужные, когда активность не на переднем плане.
// Сохранить все данные и изменения в UI.
    }
// Вызывается перед уничтожением активности
    @Override protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
        Log.v("tag", "Destroy");
// Освободить все ресурсы, включая работающие потоки, соединения с БД.
    }
}
