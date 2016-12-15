package com.example.asier.cebanc_burger;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosCliente extends MainActivity {
    private Button siguiente;
    private Button salir;
    private EditText nombre, apellidos, direccion, telefono;
    private boolean verificar = false;
    //xapi xapi

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_cliente);

        siguiente = (Button) findViewById(R.id.buttonSiguiente);
        salir = (Button) findViewById(R.id.buttonSalir);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellidos = (EditText) findViewById(R.id.editTextApellido);
        direccion = (EditText) findViewById(R.id.editTextDireccion);
        telefono = (EditText) findViewById(R.id.editTextTelefono);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar = comprobacion();
                lanzarPedido(verificar);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    public void lanzarPedido(boolean v) {
        if (v == true) {
            Intent i = new Intent(DatosCliente.this, Hamburguesas.class);
            i.putExtra("nombre", nombre.getText().toString());
            i.putExtra("apellidos", apellidos.getText().toString());
            i.putExtra("direccion", direccion.getText().toString());
            i.putExtra("telefono", telefono.getText().toString());
            startActivityForResult(i, 1234);
        }
    }

    public boolean comprobacion() {
        boolean verificar = false;
        if (nombre.getText().toString().equals("") && apellidos.getText().toString().equals("") && direccion.getText().toString().equals("") && telefono.getText().toString().equals("")) {
            Toast.makeText(this, "¡ Deberías introducir los datos para continuar !", Toast.LENGTH_SHORT).show();
            verificar = false;
        } else if (nombre.getText().toString().equals("") || apellidos.getText().toString().equals("") || telefono.getText().toString().equals("")) {
            if (nombre.getText().toString().equals("")) {
                nombre.setError("Introduce el nombre");
                verificar = false;
            }
            if (apellidos.getText().toString().equals("")) {
                apellidos.setError("Introduce el apellido ");
                verificar = false;
            }
            if (direccion.getText().toString().equals("")) {
                direccion.setError("Introduce la direccion");
                verificar = false;
            }
            if (telefono.getText().toString().equals("")) {
                telefono.setError(" Introduce el telefono");
                verificar = false;
            }
        } else {
            verificar = true;
        }
        return verificar;
    }

    public void salir() {

        finish();
    }


}
