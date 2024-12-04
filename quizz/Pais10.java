package com.example.quizz;

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

public class Pais10 extends AppCompatActivity {

    private Button btnResposta10;
    private RadioGroup rdgRespostas10;
    private RadioButton rdbAustria, rdbReinounido, rdbEua, rdbCamaroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta10 = findViewById(R.id.btnResposta10);
        rdgRespostas10 = findViewById(R.id.rdgRespostas10);
        rdbReinounido = findViewById(R.id.rdbReinounido);
        rdbAustria = findViewById(R.id.rdbAustria);
        rdbEua = findViewById(R.id.rdbEua);
        rdbCamaroes = findViewById(R.id.rdbCamaroes);

        btnResposta10.setEnabled(false);

        rdgRespostas10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta10.setEnabled(true);
                }else{
                    btnResposta10.setEnabled(false);
                }
            }
        });
        btnResposta10.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta10(v);
            }
        });


    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }
    public void resposta10(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas10.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbEua) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Final.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }
}