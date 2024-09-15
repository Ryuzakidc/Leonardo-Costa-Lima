package com.example.quizz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pais1 extends AppCompatActivity {

    private Button btnResposta;
    private RadioGroup rdgRespostas;
    private RadioButton rdbIraque;
    private RadioButton rdbBrasil;
    private RadioButton rdbGranada;
    private RadioButton rdbGuiana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta = findViewById(R.id.btnResposta);
        rdgRespostas = findViewById(R.id.rdgRespostas);
        rdbIraque = findViewById(R.id.rdbIraque);
        rdbBrasil = findViewById(R.id.rdbBrasil);
        rdbGuiana = findViewById(R.id.rdbGuiana);
        rdbGranada = findViewById(R.id.rdbGranada);

        btnResposta.setEnabled(false);

        rdgRespostas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta.setEnabled(true);
                }else{
                    btnResposta.setEnabled(false);
                }
            }
        });
        btnResposta.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta(v);
            }
        });
    }


    public void resposta(View view){
        int respostaCerta = 0;
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas.getCheckedRadioButtonId();
        if(acertos == R.id.rdbBrasil){
            respostaCerta++;
            Toast.makeText(this,"Você Acertou!", Toast.LENGTH_SHORT).show();
        }else{
                Toast.makeText(this,"Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais2.class);
        int certos = respostaCerta;
        it.putExtra("Certos", certos);
        it.putExtra("Nome",nome);
            startActivity(it);
            finish();
    }
}