package com.example.a21_pc13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class Agregar extends AppCompatActivity {

    Button btnGuardar;
    EditText txtnom,txtcod,txtmateria,txtp1,txtp2,txtp3;
    String nombre,codigo,materia;
    Double p1,p2,p3,pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        btnGuardar = findViewById(R.id.btnGuardar);
        txtnom = findViewById(R.id.txtNombre);
        txtcod = findViewById(R.id.txtCódigo);
        txtmateria = findViewById(R.id.txtMateria);
        txtp1 = findViewById(R.id.txtp1);
        txtp2 = findViewById(R.id.txtp2);
        txtp3 = findViewById(R.id.txtp3);
    }

    public void OnClickGuardar(View v){
         nombre = txtnom.getText().toString();
         codigo = txtcod.getText().toString();
         materia = txtmateria.getText().toString();
         p1 =  Double.parseDouble(txtp1.getText().toString());
         p2 =  Double.parseDouble(txtp1.getText().toString());
         p3 =  Double.parseDouble(txtp1.getText().toString());
         pro =(p1 + p2 + p3)/3 ;

        Estudiante e = new Estudiante(nombre,codigo,materia,p1,p2,p3,pro);

        Intent intent = new Intent(Agregar.this,MainActivity.class);
        intent.putExtra("estudiante", e);

        setResult(MainActivity.GUARDADO,intent);
        if(MainActivity.adaptadorEstudiante!=null){
           // MainActivity.adaptadorEstudiante.add(e);
            finish();
        }
    }
}
