package com.example.fatec_ipi_noite_gasolina_ou_etanol_exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private double gasolina = 1.0;
    private double etanol = 1.0;

    private TextView resultadoTextView;
    private TextView valorGasolinaTextView;
    private TextView valorEtanolTextView;
    private ImageView tipoCombustivelImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoTextView = findViewById(R.id.opcaoTextView);
        valorGasolinaTextView = findViewById(R.id.valorGasolinaTextView);
        valorEtanolTextView = findViewById(R.id.valorEtanolTextView);
        tipoCombustivelImageView = findViewById(R.id.tipoCombustivelImageView);

        final SeekBar precoGasolinaSeekBar =
                findViewById(R.id.precoGasolinaSeekBar);

        final SeekBar precoEtanolSeekBar =
                findViewById(R.id.precoEtanolSeekBar);

        valorGasolinaTextView.setText(currencyFormat.format(gasolina));
        valorEtanolTextView.setText(currencyFormat.format(etanol));

        precoGasolinaSeekBar.setProgress(1);
        precoEtanolSeekBar.setProgress(1);

        precoGasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gasolina = progress;
                valorGasolinaTextView.setText(currencyFormat.format(gasolina));
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        precoEtanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                etanol = progress;
                valorEtanolTextView.setText(currencyFormat.format(etanol));
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

    private void calcular() {
        double resultado = etanol / gasolina;
        if(resultado >= 0.7) {
            resultadoTextView.setText(R.string.textMelhorGasolina);
            tipoCombustivelImageView.setImageResource(R.drawable.gasolina);

        } else {
            resultadoTextView.setText(R.string.textMelhorEtanol);
            tipoCombustivelImageView.setImageResource(R.drawable.etanol);
        }
    }

}
