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

public class Pais7 extends AppCompatActivity {

    private Button btnResposta7;
    private RadioGroup rdgRespostas7;
    private RadioButton rdbAngola, rdbGuatemala, rdbUruguai, rdbEspanha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta7 = findViewById(R.id.btnResposta7);
        rdgRespostas7 = findViewById(R.id.rdgRespostas7);
        rdbAngola = findViewById(R.id.rdbAngola);
        rdbGuatemala = findViewById(R.id.rdbGuatemala);
        rdbUruguai = findViewById(R.id.rdbUruguai);
        rdbEspanha = findViewById(R.id.rdbEspanha);

        btnResposta7.setEnabled(false);

        rdgRespostas7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta7.setEnabled(true);
                }else{
                    btnResposta7.setEnabled(false);
                }
            }
        });
        btnResposta7.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta7(v);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }
    public void resposta7(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas7.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbGuatemala) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais8.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }
}