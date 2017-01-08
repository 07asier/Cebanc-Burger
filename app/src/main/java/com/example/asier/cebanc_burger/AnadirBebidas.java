package com.example.asier.cebanc_burger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Asier on 02/01/2017.
 */

public class AnadirBebidas extends DatosCliente{

    private TextView texto2;
    private long backPressedTimes = 0;
    private FloatingActionButton fab2;
    private Button siguiente;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_bebidas);

        texto2 = (TextView) findViewById(R.id.textViews);
        fab2=(FloatingActionButton)findViewById(R.id.btnAnadirBebida);
        siguiente=(Button)findViewById(R.id.buttons);

        tabLayout();


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarBebidas();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



    public void lanzarBebidas(){
        Intent i = new Intent(AnadirBebidas.this,Bebidas.class);
        startActivityForResult(i,1234);
        overridePendingTransition(R.anim.zoom_forward_in,R.anim.zoom_forward_out);
    }

    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTimes > 2000) {    // El tiempo para clickar  otra vez y salir
            backPressedTimes = t;
            Toast.makeText(this, "Pulse otra vez 'atrás' para retroceder",
                    Toast.LENGTH_SHORT).show();
        } else {

            super.onBackPressed();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }

    public void tabLayout() {
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("BEBIDAS"));




    }

}
