package com.example.quizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pais6 extends AppCompatActivity {
    private Button btnResposta6;
    private RadioGroup rdgRespostas6;
    private RadioButton rdbCuba, rdbChile, rdbBolivia, rdbBrasil;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       btnResposta6 = findViewById(R.id.btnResposta6);
       rdgRespostas6 = findViewById(R.id.rdgResposta6);
       rdbCuba = findViewById(R.id.rdbCuba);
       rdbChile = findViewById(R.id.rdbChile);
       rdbBolivia = findViewById(R.id.rdbBolivia);
       rdbBrasil = findViewById(R.id.rdbBrasil);

        btnResposta6.setEnabled(false);

        rdgRespostas6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta6.setEnabled(true);
                }else{
                    btnResposta6.setEnabled(false);
                }
            }
        });
        btnResposta6.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta6(v);
            }
        });

    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
        }
    public void resposta6(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas6.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbCuba) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais7.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }

}