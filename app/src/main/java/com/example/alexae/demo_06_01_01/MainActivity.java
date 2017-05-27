package com.example.alexae.demo_06_01_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btMain;
    private final int REQUEST_CODE = 1;
    private ListView lvMain;

    private LVMainAdapter mLVMainAdapter;

/*-------------------------------------------------------------------------------*/

    //metodo onclick listener para llamar a la otra layout desde el booton
    private final View.OnClickListener btMainOnClickListener = new
            View.OnClickListener(){
                @Override
                public void onClick(View v) {
                   Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                  startActivityForResult(intent,REQUEST_CODE);
                };
     };
/*-------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMain= (Button) findViewById(R.id.btMain);
        lvMain = (ListView)findViewById(R.id.lvMain);

        btMain.setOnClickListener(btMainOnClickListener);

        mLVMainAdapter = new LVMainAdapter(MainActivity.this);
        lvMain.setAdapter(mLVMainAdapter);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {


                Persona persona= new Persona();

                persona.setId(java.util.UUID.randomUUID().toString());
                persona.setNombre(data.getStringExtra("etNombre"));
                persona.setApellido(data.getStringExtra("etApellido"));
                persona.setDocumento(data.getStringExtra("etDocument"));
                persona.setEdad(Integer.valueOf(data.getStringExtra("etEdad")));

                 mLVMainAdapter.add(persona);

            }
        }
    }
}