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

import org.w3c.dom.Text;

public class Pais2 extends AppCompatActivity {

    private Button btnResposta2;
    private RadioGroup rdgRespostas2;
    private RadioButton rdbFranca;
    private RadioButton rdbJapao;
    private RadioButton rdbBulgaria;
    private RadioButton rdbEua;
    private TextView txtAcertos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta2 = findViewById(R.id.btnResposta2);
        rdgRespostas2 = findViewById(R.id.rdgRespostas2);
        rdbFranca = findViewById(R.id.rdbFranca);
        rdbJapao = findViewById(R.id.rdbJapao);
        rdbBulgaria = findViewById(R.id.rdbBulgaria);
        rdbEua = findViewById(R.id.rdbEua);

        btnResposta2.setEnabled(false);


        rdgRespostas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta2.setEnabled(true);
                }else{
                    btnResposta2.setEnabled(false);
                }
            }
        });
        btnResposta2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta2(v);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }

    public void resposta2(View view){
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas2.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt =  getIntent().getIntExtra("Certos", 0);
        if(acertos == R.id.rdbBulgaria){
            certosAnt +=1;
            Toast.makeText(this,"Você Acertou!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Você Errou!", Toast.LENGTH_SHORT).show();
        }


        Intent it = new Intent(this, Pais3.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }
}