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

public class Pais4 extends AppCompatActivity {

    private Button btnResposta4;
    private RadioGroup rdgRespostas4;
    private RadioButton rdbIndia, rdbArg, rdbNepal, rdbChina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta4 = findViewById(R.id.btnResposta4);
        rdgRespostas4 = findViewById(R.id.rdgRespostas4);
        rdbIndia = findViewById(R.id.rdbIndia);
        rdbArg = findViewById(R.id.rdbArg);
        rdbNepal = findViewById(R.id.rdbNepal);
        rdbChina = findViewById(R.id.rdbChina);

        btnResposta4.setEnabled(false);

        rdgRespostas4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta4.setEnabled(true);
                }else{
                    btnResposta4.setEnabled(false);
                }
            }
        });
        btnResposta4.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta4(v);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }

    public void resposta4(View view){
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas4.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt =  getIntent().getIntExtra("Certos", 0);
        if(acertos == R.id.rdbChina){
            certosAnt++;
            Toast.makeText(this,"Você Acertou!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais5.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();

    }
}