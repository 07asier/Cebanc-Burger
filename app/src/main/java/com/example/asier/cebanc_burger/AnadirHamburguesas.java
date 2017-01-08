package com.example.asier.cebanc_burger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Asier on 14/12/2016.
 */

public class AnadirHamburguesas extends DatosCliente {
    private TextView texto;
    private long backPressedTime = 0;
    private FloatingActionButton fab;
    private Button bebidas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_hamburguesas);
        texto = (TextView) findViewById(R.id.textView14);
        fab=(FloatingActionButton)findViewById(R.id.btnAnadirBurger);
        bebidas=(Button)findViewById(R.id.button);

        tabLayout();
        recogerDatosHamburguesa();

        bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaBebidas();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               lanzarHamburguesas();
            }
        });




    }

    public void recogerDatosHamburguesa() {
        Bundle extras = getIntent().getExtras();
        String s = "Hola " + extras.getString("nombre") + ", escoge las hamburguesas:";
        texto.setText(s);
    }

    public void lanzarHamburguesas(){
        Intent in=new Intent(AnadirHamburguesas.this,Hamburguesas.class);
        startActivityForResult(in,1234);
        overridePendingTransition(R.anim.zoom_forward_in,R.anim.zoom_forward_out);

    }

    public void lanzaBebidas(){
        Intent i=new Intent(AnadirHamburguesas.this,AnadirBebidas.class);
        startActivityForResult(i,1234);
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




    }




}


