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
        EditText editQuantidadeLitros = findViewById(R.id.editTextQuantidadeLitros);
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
                String quantidadeLitrosStr = editQuantidadeLitros.getText().toString();

                if (!valorEtanolStr.isEmpty() && !valorGasolinaStr.isEmpty() && !quantidadeLitrosStr.isEmpty()) {
                    double valorEtanol = Double.parseDouble(valorEtanolStr);
                    double valorGasolina = Double.parseDouble(valorGasolinaStr);
                    double quantidadeLitros = Double.parseDouble(quantidadeLitrosStr);

                    double percentual = (valorEtanol / valorGasolina) * 100;
                    String resultadoFormatado = String.format("%.2f%%", percentual);

                    String combustivelRecomendado;
                    double valorTotal;

                    if (percentual <= 70) {
                        combustivelRecomendado = "Etanol";
                        valorTotal = valorEtanol * quantidadeLitros;
                    } else {
                        combustivelRecomendado = "Gasolina";
                        valorTotal = valorGasolina * quantidadeLitros;
                    }

                    String valorTotalFormatado = String.format("%.2f", valorTotal);

                    String resultado = "Perc. " + resultadoFormatado + "\n" +
                            "Abasteça com " + combustivelRecomendado + "\n" +
                            "Valor total da oferta: R$ " + valorTotalFormatado;

                    textViewResultado.setText(resultado);


                } else {

                    textViewResultado.setText("Preencha todos os campos.");
                }
            }
        });
//
    }
}