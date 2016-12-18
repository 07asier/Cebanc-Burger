package com.example.asier.cebanc_burger;

import android.os.Bundle;

/**
 * Created by Asier on 18/12/2016.
 */

public class Hamburguesas extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamburguesas);
    }
        public void onBackPressed(){
            super.onBackPressed();
            overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);
        }




}
