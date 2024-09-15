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

public class Pais3 extends AppCompatActivity {

    private Button btnResposta3;
    private RadioGroup rdgRespostas3;
    private RadioButton rdbCanada;
    private RadioButton rdbChina;
    private RadioButton rdbItalia;
    private RadioButton rdbCoreia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta3 = findViewById(R.id.btnResposta3);
        rdgRespostas3 = findViewById(R.id.rdgRespostas3);
        rdbCanada = findViewById(R.id.rdbCanada);
        rdbChina = findViewById(R.id.rdbChina);
        rdbItalia = findViewById(R.id.rdbItalia);
        rdbCoreia = findViewById(R.id.rdbCoreia);

        btnResposta3.setEnabled(false);

        rdgRespostas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta3.setEnabled(true);
                }else{
                    btnResposta3.setEnabled(false);
                }
            }
        });
        btnResposta3.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta3(v);
            }
        });

    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }

    public void resposta3(View view){
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas3.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt =  getIntent().getIntExtra("Certos", 0);
        if(acertos == R.id.rdbCanada){
            certosAnt++;
            Toast.makeText(this,"Você Acertou!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Você Errou!", Toast.LENGTH_SHORT).show();
        }

        Intent it = new Intent(this, Pais4.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
         finish();



    }
}