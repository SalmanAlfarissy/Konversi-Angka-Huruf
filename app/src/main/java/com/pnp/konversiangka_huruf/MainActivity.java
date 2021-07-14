package com.pnp.konversiangka_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView terbilang;
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
        terbilang = findViewById(R.id.terbilang);

        terbilang.setVisibility(View.GONE);
        number.addTextChangedListener(inputtext);
    }



    private final TextWatcher inputtext = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            terbilang.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {
            Konversi konversiAngka = new Konversi();
            if  (s.length() == 0){
                terbilang.setVisibility(View.GONE);

            }else {
                int angka = Integer.parseInt(number.getText().toString());
                terbilang.setText(konversiAngka.angka(angka));
            }

        }
    };




}