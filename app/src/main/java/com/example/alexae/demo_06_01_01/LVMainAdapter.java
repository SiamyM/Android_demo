package com.example.alexae.demo_06_01_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alex.ae on 23/05/2017.
 */

public class LVMainAdapter extends ArrayAdapter<Persona> {


    public LVMainAdapter(Context context) {

        super(context,0,new ArrayList<Persona>());
    }


    public View getView(int position, View convertView, ViewGroup parent) {

       if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);

        TextView tvMainItemFullname, tvMainItemDocument, tvMainItemAge;

        tvMainItemFullname = (TextView) convertView.findViewById(R.id.tvMainItemFullname);
        tvMainItemDocument = (TextView) convertView.findViewById(R.id.tvMainItemDocument);
        tvMainItemAge = (TextView) convertView.findViewById(R.id.tvMainItemAge);

        //OBTENGO LA PERSONA DE MI LISTA EN LA POSICIÃ“N SOLICITADA
        Persona persona = getItem(position);

        tvMainItemFullname.setText(persona.getNombre()+" "+persona.getApellido());
        tvMainItemDocument.setText(persona.getDocumento());
        tvMainItemAge.setText(String.valueOf(persona.getEdad()));
        return convertView;

    }
}
