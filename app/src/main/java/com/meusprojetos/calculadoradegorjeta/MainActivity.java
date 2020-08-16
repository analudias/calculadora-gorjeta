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
    private EditText editTextGorjeta;
    private EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        textSeekBar = findViewById(R.id.textSeekBar);
        seekBar = findViewById(R.id.seekBar);
        editTextGorjeta = findViewById(R.id.editTextGorjeta);
        editTextTotal = findViewById(R.id.editTextTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress * 10;
                textSeekBar.setText(progress + "%");
                double valor = Double.parseDouble(editTextValor.getText().toString());
                String valorTexto = String.valueOf(valor * progress / 100);
                editTextGorjeta.setText("R$ " + valorTexto);
                editTextTotal.setText("R$ " + );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //double valor = Double.parseDouble(editTextTotal.getText().toString());
                //String valorTexto = String.valueOf(valor * seekBar.getProgress() * 10);
                //editTextGorjeta.setText(valorTexto);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


}
