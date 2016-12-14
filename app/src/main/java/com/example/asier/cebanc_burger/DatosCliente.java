package com.example.asier.cebanc_burger;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatosCliente extends MainActivity {
    Button siguiente;
    Button salir;
    EditText nombre,apellidos,direccion,telefono;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_cliente);

        siguiente = (Button) findViewById(R.id.buttonSiguiente);
        salir=(Button)findViewById(R.id.buttonSalir);
        nombre=(EditText) findViewById(R.id.editTextNombre);
        apellidos=(EditText)findViewById(R.id.editTextApellido);
        direccion=(EditText)findViewById(R.id.editTextDireccion);
        telefono=(EditText)findViewById(R.id.editTextTelefono);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            lanzarPedido();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });

    }

    public void lanzarPedido(){
       Intent i=new Intent(DatosCliente.this,Pizzas.class);
        i.putExtra("nombre",nombre.getText().toString());
        i.putExtra("apellidos",apellidos.getText().toString());
        i.putExtra("direccion",direccion.getText().toString());
        i.putExtra("telefono",telefono.getText().toString());
        startActivityForResult(i,1234);
    }

    public void salir(){
        finish();
    }


}
