package com.meusprojetos.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextValor;
    private TextView textSeekBar;
    private SeekBar seekBar;
    private TextView textViewGorjeta;
    private TextView textViewTotal;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        textSeekBar = findViewById(R.id.textSeekBar);
        seekBar = findViewById(R.id.seekBar);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //definindo o valor da progresso para a porcentagem para não causar erro no cálculo com números decimais
                porcentagem = progress;
                textSeekBar.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });


    }

    public void calcular(){

        String valorRecuperado = editTextValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }
        else{

            //Converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //Calcula a gorjeta e total
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            //Exibe a gorjeta e total
            textViewGorjeta.setText("R$ " + gorjeta);
            textViewTotal.setText("R$ " + total);
        }
    }


}
