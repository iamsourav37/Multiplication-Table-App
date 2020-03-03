package com.backpakcersourav;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar number;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.my_custom_layout,R.id.text_view, arrayList);

        number = findViewById(R.id.seekbar);
        number.setMax(101);
        number.setMin(1);
        number.setProgress(5);

        list = findViewById(R.id.listview);
        list.setAdapter(adapter);
        this.setMultTable(number.getProgress());

        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setMultTable(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapter.getItem(i);
                Toast toast= Toast.makeText(getApplicationContext(),
                        str, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

    }

    private void setMultTable(int n){
        adapter.clear();
        for (int i=1; i<=10; i++){
            String str = n+" X "+i+" = "+(n*i);
            adapter.add(str);
        }
        adapter.notifyDataSetChanged();
    }
}


