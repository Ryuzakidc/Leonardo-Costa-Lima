package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Final extends AppCompatActivity {
    private TextView txtNomeR, txtAcertos;
    private Button btnNova, btnTelaP;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNomeR = findViewById(R.id.txtNomeR);
        txtAcertos = findViewById(R.id.txtAcertos);
        btnNova = findViewById(R.id.btnNova);
        btnTelaP = findViewById(R.id.btnTelaP);

        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);

        txtNomeR.setText(getIntent().getStringExtra("Nome"));
        txtAcertos.setText(String.valueOf(certosAnt));


    }

    public void sair(View view){
        finish();
    }

    public void jogarNovamente(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

}