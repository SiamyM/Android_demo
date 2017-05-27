package com.example.alexae.demo_06_01_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alex.ae on 23/05/2017.
 */

public class SecondActivity extends AppCompatActivity{


    Button btSecond ;
    EditText etNombre,etApellido,etDocument,etEdad;

    private final View.OnClickListener btSecondActivityOnClickListener =
            new View.OnClickListener(){


                @Override
                public void onClick(View view) {

                    Intent intent= new Intent();
                    intent.putExtra("etNombre",etNombre.getText().toString());
                    intent.putExtra("etApellido",etApellido.getText().toString());
                    intent.putExtra("etDocument",etDocument.getText().toString());
                    intent.putExtra("etEdad",etEdad.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();

                }
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etDocument = (EditText) findViewById(R.id.etDocument);
        etEdad = (EditText) findViewById(R.id.etEdad);
        btSecond=(Button) findViewById(R.id.btSecond);
        btSecond.setOnClickListener(btSecondActivityOnClickListener);
    }
}
