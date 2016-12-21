package com.example.asier.cebanc_burger;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.String.*;

/**
 * Created by Asier on 18/12/2016.
 */

public class Hamburguesas extends MainActivity {
    private Spinner spinnerTamaño,spinnerCarne;
    private FloatingActionButton fabInfoTamaño,fabInfoCarne;
    //final String[] tamaño = new String[]{"Normal","Whopper"};

    final String[] carnes=new String[]{"Ternera","Pollo","Buey"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamburguesas);


        spinnerCarne = (Spinner) findViewById(R.id.spinnerCarne);
        fabInfoTamaño = (FloatingActionButton) findViewById(R.id.fabInfoTamaño);
        fabInfoCarne = (FloatingActionButton) findViewById(R.id.fabInfoCarne);


        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("Hamburguesa normal", R.drawable.hamburguesanormal));
        list.add(new ItemData("Hamburguesa 'Whopper' ", R.drawable.hamburguesadoble));
        spinnerTamaño = (Spinner) findViewById(R.id.spinnerTamaño);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, R.id.txt, list);
        spinnerTamaño.setAdapter(adapter);

        fabInfoTamaño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar(v);

            }
        });


        fabInfoCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Hamburguesas.this);
                dialogo1.setTitle("Información");
                dialogo1.setMessage("Ternera : Deliciosa carne 100% vacuno vasca" +
                        "Valor nutricional(por cada 100g):" +
                        "Energía:1136kJ" +
                        "Grasas:14g" +
                        "Carbohidratos:22g" +
                        "Proteina:13g" +
                        "Pollo : Exquisito pollo criado en la región" +
                        "Valor nutricional(por cada 100g):"+
                        "Energía:967kJ" +
                        "Grasas:10g" +
                        "Carbohidratos:23g" +
                        "Proteina:11g" +
                        "Buey : El mejor buey regional" +
                        "Valor nutricional(por cada 100g):"+
                        "Energía:917kJ" +
                        "Grasas:11g" +
                        "Carbohidratos:20g" +
                        "Proteina:15g");
                dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //nada
                    }
                });
                dialogo1.show();
            }
        });


}

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }

    public void mostrar(View view)
    {
        // con este tema personalizado evitamos los bordes por defecto
        final Dialog customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.info_tam);

        TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
        titulo.setText("Título del Dialog");

        TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
        contenido.setText("Mensaje con el contenido del dialog" +
                                "con el contenido del dialog" +
                                "con el contenido del dialog"+
                                    "con el contenido del dialog");





        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                customDialog.dismiss();


            }
        });

        ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                customDialog.dismiss();


            }
        });

        customDialog.show();
    }


}
