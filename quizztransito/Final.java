package com.example.quizztransito;

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

public class Final extends AppCompatActivity {

    private Button btnJogar, btnSair;
    private TextView txtResultado;


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

        btnJogar = findViewById(R.id.btnJogar);
        btnSair = findViewById(R.id.btnSair);
        txtResultado = findViewById(R.id.txtResultado);

        Intent intent = getIntent();
        int rCerta = getIntent().getIntExtra("rCerta", 0);
        txtResultado.setText(String.valueOf(rCerta));
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método

    }

    public void jogar(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void sair(View view){
        Intent it = new Intent(this, Final.class);
        finish();

    }
}