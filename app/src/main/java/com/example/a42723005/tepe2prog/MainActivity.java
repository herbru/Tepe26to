package com.example.a42723005.tepe2prog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.security.KeyStore;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton[] arrayBotones;
    LinearLayout linear1 = (LinearLayout)findViewById(R.id.Linear1);
    LinearLayout linear2 = (LinearLayout)findViewById(R.id.Linear2);
    LinearLayout linear3 = (LinearLayout)findViewById(R.id.Linear3);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //declaro el array de botones
        arrayBotones = new ImageButton[9];
        arrayBotones[0] =(ImageButton)findViewById(R.id.btnUno);
        arrayBotones[1] =(ImageButton)findViewById(R.id.btnDos);
        arrayBotones[2] =(ImageButton)findViewById(R.id.btnTres);
        arrayBotones[3] =(ImageButton)findViewById(R.id.btnCuatro);
        arrayBotones[4] =(ImageButton)findViewById(R.id.btnCinco);
        arrayBotones[5] =(ImageButton)findViewById(R.id.btnSeis);
        arrayBotones[6] =(ImageButton)findViewById(R.id.btnSiete);
        arrayBotones[7] =(ImageButton)findViewById(R.id.btnOcho);
        arrayBotones[8] =(ImageButton)findViewById(R.id.btnNueve);

        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.VISIBLE);
        linear3.setVisibility(View.VISIBLE);

    }

    public boolean verificarSiGano()
    {
        boolean sonIguales = true;
        ImageButton primerposicion = arrayBotones[0];
        for (ImageButton imgbtn: arrayBotones) {
            if (primerposicion.getDrawable() != imgbtn.getDrawable()){
                sonIguales = false;
            }
        }
        return  sonIguales;
    }

    public void invertirImagenBoton(int nroBotonPresionado){
        if (nroBotonPresionado == 0){
            arrayBotones[nroBotonPresionado].setImageResource(R.drawable.azul);
        }
        else{
            arrayBotones[nroBotonPresionado].setImageResource(R.drawable.rojo);
        }
    }

    public void generar (View vista)
    {
        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.VISIBLE);
        linear3.setVisibility(View.VISIBLE);

        //instancio e incializo un generador de randoms
        Random generadorRandom;
        generadorRandom = new Random();

        int sumaTotalNumeros = 0;

        boolean estaBien = false;

        //genero un array de numeros, 1 o 0, y verifico que todas las posiciones no sean iguales
        while(!estaBien)
        {
            for (ImageButton imgbtn: arrayBotones) {
                int nroRandom = generadorRandom.nextInt(2);

                if (nroRandom == 0){
                    imgbtn.setImageResource(R.drawable.azul);
                }
                else{
                    imgbtn.setImageResource(R.drawable.rojo);
                }
            }
            //verifico si todas las imagenes son iguales
            estaBien = verificarSiGano();
        }
    }

    public void  Actualizar(View vista){
        //obtengo el imagebutton que fue presionado
        ImageButton botonPresionado =(ImageButton)vista;

        //obtengo el tag en tipo string del boton botonPresionado
        String tagBotonPresionado = botonPresionado.getTag().toString();

        //convierto el tag en int
        int numeroBotonPresionado = Integer.parseInt(tagBotonPresionado);
        switch (numeroBotonPresionado){
            //invierto los botones de acuerdo al boton presionado
            case  0:
                invertirImagenBoton(0);
                invertirImagenBoton(1);
                invertirImagenBoton(3);
                break;
            case 1:
                invertirImagenBoton(1);
                invertirImagenBoton(0);
                invertirImagenBoton(2);
                invertirImagenBoton(4);
                break;
            case 2:
                invertirImagenBoton(2);
                invertirImagenBoton(1);
                invertirImagenBoton(4);
                invertirImagenBoton(5);
                break;
            case 3:
                invertirImagenBoton(3);
                invertirImagenBoton(0);
                invertirImagenBoton(4);
                invertirImagenBoton(6);
                break;
            case 4:
                invertirImagenBoton(4);
                invertirImagenBoton(1);
                invertirImagenBoton(3);
                invertirImagenBoton(7);
                invertirImagenBoton(5);
                break;
            case 5:
                invertirImagenBoton(5);
                invertirImagenBoton(2);
                invertirImagenBoton(4);
                invertirImagenBoton(8);
                break;
            case 6:
                invertirImagenBoton(6);
                invertirImagenBoton(3);
                invertirImagenBoton(7);
                break;
            case 7:
                invertirImagenBoton(7);
                invertirImagenBoton(6);
                invertirImagenBoton(8);
                invertirImagenBoton(4);
                break;
            case 8:
                invertirImagenBoton(8);
                invertirImagenBoton(5);
                invertirImagenBoton(7);
                break;
        }
        if (verificarSiGano()){
            Toast.makeText(this, "GANASTEEE!!!!!", Toast.LENGTH_SHORT).show();
        }

    }
}
