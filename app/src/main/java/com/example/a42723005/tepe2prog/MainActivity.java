package com.example.a42723005.tepe2prog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void iniciar (View vista)
    {
        Random generador;
        generador = new Random();

        boolean estaBien = false;
        boolean cero = false;
        boolean uno = false;

        int [] array = new int[9];


        while(estaBien == false)
        {
            for (int i = 0 ; i <= 9 ; i++)
            {
                int numeroImagen;
                numeroImagen = generador.nextInt(2);

                array[i]=numeroImagen;

                if (numeroImagen == 1)
                {
                    uno = true;
                }
                else
                {
                    cero = true;
                }
            }

            if (cero == true && uno == true)
            {
                estaBien = true;
            }
        }
        Toast.makeText(this, "mi array" + array, Toast.LENGTH_SHORT).show();
    }
}
