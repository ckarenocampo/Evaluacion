package com.example.a21_pc13.myapplication;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int GUARDADO=1;
    public Button btnAgregar,btnMostrar;
    public ArrayList<Estudiante> estuArrayList;
    public static AdaptadorEstudiante adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnMostrar = findViewById(R.id.btnMostrar);

        estuArrayList = new ArrayList<>();
        adaptadorEstudiante = new AdaptadorEstudiante(this,  estuArrayList);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Agregar.class);
                startActivityForResult(intent,GUARDADO);
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Mostrar.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Bundle extras = data.getExtras();
            if(extras!=null) {
                Estudiante es = (Estudiante) data.getSerializableExtra("estudiante");
                adaptadorEstudiante.add(es);
                btnMostrar.setText("Listado estudiantes "+adaptadorEstudiante.getCount());

            }
        }
    }
}
