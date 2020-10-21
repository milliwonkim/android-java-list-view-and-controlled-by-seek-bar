package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for(int j = 1; j <= 10; j++) {
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ---------------

        // 초기 데이터

        ListView friendsListView = findViewById(R.id.timesTablesListView);

        final ArrayList<String> myFriends = new ArrayList<String>(asList("Mark", "Jane", "Sussy", "Jan"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        friendsListView.setAdapter(arrayAdapter);

        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Hello " + myFriends.get(position), Toast.LENGTH_LONG).show();
            }
        });

        // -------------

        final SeekBar timesTableSeekbar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView  = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPosition = 10;

        timesTableSeekbar.setMax(max);
        timesTableSeekbar.setProgress(startingPosition);

        generateTimesTable(10);

        timesTableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(progress < min) {
                    timesTableNumber = min;
                    timesTableSeekbar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }

                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}