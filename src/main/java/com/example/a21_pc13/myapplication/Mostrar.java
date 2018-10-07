package com.example.a21_pc13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class Mostrar extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listView = findViewById(R.id.lista);

        if(MainActivity.adaptadorEstudiante!=null){
            listView.setAdapter(MainActivity.adaptadorEstudiante);
       }
    }
}
