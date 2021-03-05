package com.example.lr6;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Attraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        String[] town = getResources().getStringArray(R.array.Croatia);
        TextView tw = (TextView) findViewById(R.id.textView4);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, town);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ListView attractionsList = (ListView) findViewById(R.id.attractionsList);

        final ArrayList<String> attraction = new ArrayList<>();
        final ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attraction);
        attractionsList.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                attraction.clear();
                String[] att = {};
                switch (position) {
                    case 0:
                        att = getResources().getStringArray(R.array.t1);
                        break;
                    case 1:
                        att = getResources().getStringArray(R.array.t2);
                        break;
                    case 2:
                        att = getResources().getStringArray(R.array.t3);
                        break;
                    case 3:
                        att = getResources().getStringArray(R.array.t4);
                        break;
                    case 4:
                        att = getResources().getStringArray(R.array.t5);
                        break;
                    case 5:
                        att = getResources().getStringArray(R.array.t6);
                        break;
                    default:
                }
                attraction.addAll(Arrays.asList(att));
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
}