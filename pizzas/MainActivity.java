package com.example.pizzas;

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

    private EditText edtN1, edtN2, edtN3, edtN4;
    private Button btnCalc;
    private TextView txtValor;

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

        edtN1 = findViewById(R.id.edtN1);
        edtN2 = findViewById(R.id.edtN2);
        edtN3 = findViewById(R.id.edtN3);
        edtN4 = findViewById(R.id.edtN4);
        btnCalc = findViewById(R.id.btnCalc);
        txtValor = findViewById(R.id.txtValor);
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método

    }

    public void calcular(View view) {
        try {
            double n1 = edtN1.getText().toString().isEmpty() ? 0 : Double.parseDouble(edtN1.getText().toString());
            double n2 = edtN2.getText().toString().isEmpty() ? 0 : Double.parseDouble(edtN2.getText().toString());
            double n3 = edtN3.getText().toString().isEmpty() ? 0 : Double.parseDouble(edtN3.getText().toString());
            double n4 = edtN4.getText().toString().isEmpty() ? 0 : Double.parseDouble(edtN4.getText().toString());

            double total = n1 * 24.90 + n2 * 27.90 + n3 * 30.90 + n4 * 25.90;

            txtValor.setText(String.format("%.2f", total));
        } catch (NumberFormatException e){
                txtValor.setText("Por favor, insira números válidos!");
        }
    }
}