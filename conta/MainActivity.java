package com.example.conta;

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

    private TextView txtPessoa, txtConta, txtTaxa;
    private EditText edtConsumo, edtCouver, edtPessoa;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPessoa = findViewById(R.id.txtPessoa);
        txtConta = findViewById(R.id.txtConta);
        txtTaxa = findViewById(R.id.txtTaxa);
        btnCalc = findViewById(R.id.btnCalc);
        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouver = findViewById(R.id.edtCouver);
        edtPessoa = findViewById(R.id.edtPessoas);
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método

    }

    public void calcular(View view){
        try {
            double nConsumo = Double.parseDouble(edtConsumo.getText().toString());
            double nCouver = edtCouver.getText().toString().isEmpty() ? 0: Double.parseDouble(edtCouver.getText().toString());
            int nPessoa = Integer.parseInt(edtPessoa.getText().toString());

            double taxa = nConsumo * 0.1;
            double total = nConsumo + nCouver + taxa;
            double pessoa = total / nPessoa ;

            txtPessoa.setText(String.format("%.2f", pessoa));
            txtConta.setText(String.format("%.2f", total));
            txtTaxa.setText(String.format("%.2f", taxa));
        } catch (NumberFormatException e){

        }
    }
}