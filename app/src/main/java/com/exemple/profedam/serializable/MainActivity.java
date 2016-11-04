package com.exemple.profedam.serializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyObject myObject = new MyObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    if (savedInstanceState!=null)

     {
         myObject = (MyObject) savedInstanceState.getSerializable("myObject");
         rellenarTextView();
     }





        Button btnMostrar = (Button) findViewById(R.id.btn_mostrar);
        Button btnCrear = (Button) findViewById (R.id.btn_crear);
        btnMostrar.setOnClickListener(this);
        btnCrear.setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btn_crear)
        {
            ArrayList<String> adreces = new ArrayList();
            adreces.addAll(Arrays.asList((new String[] {"C/Major 10", "C/Menor 12"})));
             myObject = new MyObject("Pepe", (new Random()).nextInt(100), adreces);
             Toast.makeText(this, "objeto creado", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.btn_mostrar)
        {

            rellenarTextView();


        }


    }

    public void rellenarTextView() {
        String frase = "Nombre: " + myObject.getName() + " Edad:" + myObject.getAge();
        for (String contador:myObject.getAddress())
        {
            frase += " Direccion " + contador;
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(frase);
    }

    @Override

    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable("myObject", myObject);
        super.onSaveInstanceState(outState);

    }

}
