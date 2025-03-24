package com.example.abaestececerto;

import static com.example.abaestececerto.R.id.buttonCalcular;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextValorLitroEtanol = findViewById(R.id.editTextValorLitroEtanol);
        EditText editTextValorLitroGasolina = findViewById(R.id.editTextValorLitroGasolina);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        ViewCompat.setOnApplyWindowInsetsListener(editTextValorLitroEtanol, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         ViewCompat.setOnApplyWindowInsetsListener(editTextValorLitroGasolina, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorEtanolStr = editTextValorLitroEtanol.getText().toString();
                String valorGasolinaStr = editTextValorLitroGasolina.getText().toString();

                if (!valorEtanolStr.isEmpty() && !valorGasolinaStr.isEmpty()) {
                    double valorEtanol = Double.parseDouble(valorEtanolStr);
                    double valorGasolina = Double.parseDouble(valorGasolinaStr);

                    double percentual = (valorEtanol / valorGasolina) * 100;

                    textViewResultado.setText(String.format("%.2f%%", percentual));
                } else {

                    textViewResultado.setText("Preencha todos os campos.");
                }
            }
        });
    }
}