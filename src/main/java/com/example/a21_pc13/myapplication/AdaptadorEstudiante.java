package com.example.a21_pc13.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {
    public AdaptadorEstudiante(@NonNull Context context, @NonNull List<Estudiante> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Estudiante estu = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estu, parent, false);
        }

        TextView lblid = convertView.findViewById(R.id.lblid);
        TextView lblnombre = convertView.findViewById(R.id.lblNombre);
        TextView lblcodigo = convertView.findViewById(R.id.lblcodigo);
        TextView lblmateria = convertView.findViewById(R.id.lblmateria);
        TextView lblpromedio = convertView.findViewById(R.id.lblpromedio);

        lblid.setText(position);
        lblnombre.setText(estu.nombre);
        lblcodigo.setText(estu.codigo);
        lblmateria.setText(estu.materia);
        lblpromedio.setText(estu.promedio+ "");

        return convertView;

    }
}
