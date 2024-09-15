package com.example.quizztransito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Placa3 extends AppCompatActivity {

    private Button btnNext, btnr1, btnr2, btnr3, btnr4;
    private boolean btnCerto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_placa3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnr1 = findViewById(R.id.btnr1);
        btnr2 = findViewById(R.id.btnr2);
        btnr3 = findViewById(R.id.btnr3);
        btnr4 = findViewById(R.id.btnr4);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setEnabled(false);


        btnr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCerto = true;
                btnNext.setEnabled(true);
                btnr1.setEnabled(false);
                btnr2.setEnabled(false);
                btnr3.setEnabled(false);
                btnr4.setEnabled(false);
            }
        });

        btnr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnr1.setEnabled(false);
                btnr2.setEnabled(false);
                btnr3.setEnabled(false);
                btnr4.setEnabled(false);
            }
        });

        btnr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnr1.setEnabled(false);
                btnr2.setEnabled(false);
                btnr3.setEnabled(false);
                btnr4.setEnabled(false);
            }
        });

        btnr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnr1.setEnabled(false);
                btnr2.setEnabled(false);
                btnr3.setEnabled(false);
                btnr4.setEnabled(false);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método

    }
    public void next(View view){
        int rCerta = getIntent().getIntExtra("rCerta", 0);
        if(btnCerto) {
            rCerta++;
            Toast.makeText(this, "Reposta Certa!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Resposta Errada!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this,Placa4.class);
        it.putExtra("rCerta", rCerta);
        startActivity(it);
        finish();
    }
}
