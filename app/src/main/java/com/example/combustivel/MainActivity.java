package com.example.combustivel;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private TextView precoGasolinaTextView;
    private TextView precoEtanolTextView;
    private TextView resultTextView;
    private ImageView combustivelImageView;
    private double precoGasolina = 6.00;
    private double precoEtanol = 2.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolinaTextView = findViewById(R.id.precoGasolinaTextView);
        SeekBar gasolinaSeekBar = findViewById(R.id.gasolinaSeekBar);
        gasolinaSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListenerGaso);

        precoEtanolTextView = findViewById(R.id.precoEtanolTextView);
        SeekBar etanolSeekBar = findViewById(R.id.etanolSeekBar);
        etanolSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListenerEta);

        precoGasolinaTextView.setText(currencyFormat.format(precoGasolina));
        precoEtanolTextView.setText(currencyFormat.format(precoEtanol));

        resultTextView = findViewById(R.id.resultTextView);
        combustivelImageView = findViewById(R.id.combustivelImageView);
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerGaso = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoGasolina = progress / 100.0;
            precoGasolinaTextView.setText(currencyFormat.format(precoGasolina));
            escolha();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerEta = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoEtanol = progress / 100D;
            precoEtanolTextView.setText(currencyFormat.format(precoEtanol));
            escolha();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void escolha (){
        float result = (float) (precoEtanol/precoGasolina * 1D);
        if (result >= 0.7) {
            resultTextView.setText(getString(R.string.gasolinaString));
            combustivelImageView.setImageResource(R.drawable.gasolina);
        }else{
            resultTextView.setText(getString(R.string.etanolString));
            combustivelImageView.setImageResource(R.drawable.etanol);
        }
    }
}
