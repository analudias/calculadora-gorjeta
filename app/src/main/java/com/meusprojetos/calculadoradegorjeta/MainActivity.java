package com.meusprojetos.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

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
                textSeekBar.setText(porcentagem + "%");

                //pegando o texto com o valor da conta e transformando em número
                double valor = Double.parseDouble(editTextValor.getText().toString());
                String valorTexto = String.valueOf(valor * porcentagem / 100);
                textViewGorjeta.setText("R$ " + valorTexto);

                //pegando o valor da gorjeta para calcular o valor total
                Double valorTotal = Double.parseDouble(valorTexto);
                String valorTextoTotal = String.valueOf(valorTotal + valor);
                textViewTotal.setText("R$ " + valorTextoTotal);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });


    }


}
