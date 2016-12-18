package com.example.asier.cebanc_burger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Asier on 14/12/2016.
 */

public class AnadirHamburguesas extends DatosCliente {
    private TextView texto;
    private long backPressedTime = 0;
    private FloatingActionButton fab;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_hamburguesas);
        texto = (TextView) findViewById(R.id.textView9);
        fab=(FloatingActionButton)findViewById(R.id.btnAnadirBurger);
        tabLayout();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarHamburguesas();

            }
        });
    }

    public void recogerDatosHamburguesa() {
        Bundle extras = getIntent().getExtras();
        String s = "Hola " + extras.getString("nombre") + ", escoga las anadir_hamburguesas:";
        texto.setText(s);
    }

    public void lanzarHamburguesas(){
        Intent in=new Intent(AnadirHamburguesas.this,Hamburguesas.class);
        startActivityForResult(in,1234);
        overridePendingTransition(R.anim.zoom_forward_in,R.anim.zoom_forward_out);

    }

    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // El tiempo para clickar  otra vez y salir
            backPressedTime = t;
            Toast.makeText(this, "Pulse otra vez 'atrás' para retroceder",
                    Toast.LENGTH_SHORT).show();
        } else {

            super.onBackPressed();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }

    public void tabLayout() {
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("HAMBURGUESAS"));
        tabs.setTabMode(TabLayout.MODE_FIXED);

    }




}


