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
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private NumberPicker numberPicker;
    private RadioGroup radioGroup;
    private RadioButton radioButton1 , radioButton2 , radioButton3 , radioButton4 , radioButton5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamburguesas);

        spinnerTamaño = (Spinner) findViewById(R.id.spinnerTamaño);
        spinnerCarne = (Spinner) findViewById(R.id.spinnerCarne);
        fabInfoTamaño = (FloatingActionButton) findViewById(R.id.fabInfoTamaño);
        fabInfoCarne = (FloatingActionButton) findViewById(R.id.fabInfoCarne);
        numberPicker=(NumberPicker)findViewById(R.id.numberPicker2);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        radioButton4=(RadioButton)findViewById(R.id.radioButton4);
        radioButton5=(RadioButton)findViewById(R.id.radioButton5);


        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.tamcarne,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this,R.array.tipodecarne,android.R.layout.simple_spinner_item);
        spinnerTamaño.setAdapter(adapter);
        spinnerCarne.setAdapter(adapter2);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);
        numberPicker.setWrapSelectorWheel(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1){

                }else if(checkedId ==R.id.radioButton2){

                }else if(checkedId ==R.id.radioButton3){

                }else if(checkedId == R.id.radioButton4){

                }else if(checkedId == R.id.radioButton5){

                }
            }
        });



        fabInfoTamaño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTam(v);

            }
        });

        fabInfoCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mostrarTipo(v);

            }
        });


}

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }

    public void mostrarTam(View view) {
        final Dialog customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.info_tam);

        TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
        titulo.setText("Información");

        TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
        contenido.setText("Normal: Es el tamaño de hamburguesa estándar, 150g de carne.Es el tamaño más popular. \n"+
                          " \n"+
                          "Whopper : Es el tamaño de hamburguesa más grande que disponemos, 300g de carne , para los más fanáticos de las hamburguesas.");


        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });


        customDialog.show();
    }

    public void mostrarTipo(View view){
        final Dialog customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.info_tam);

        TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
        titulo.setText("Información");

        TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
        contenido.setText(" -Ternera : Deliciosa carne 100% vacuno vasca\n" +
                "     Valor nutricional(por cada 100g):\n" +
                "     Energía:1136kJ\n" +
                "     Grasas:14g\n" +
                "     Carbohidratos:22g\n" +
                "     Proteina:13g\n" +
                " -Pollo : Exquisito pollo criado en la región\n" +
                "     Valor nutricional(por cada 100g):\n"+
                "     Energía:967kJ\n" +
                "     Grasas:10g\n" +
                "     Carbohidratos:23g\n" +
                "     Proteina:11g\n" +
                " -Buey : El mejor buey regional\n" +
                "     Valor nutricional(por cada 100g):\n"+
                "     Energía:917kJ\n" +
                "     Grasas:11g\n" +
                "     Carbohidratos:20g\n" +
                "     Proteina:15g\n");

        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });

        customDialog.show();
    }


}
