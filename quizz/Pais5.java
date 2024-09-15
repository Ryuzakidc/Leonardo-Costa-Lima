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

public class Pais5 extends AppCompatActivity {
    private Button btnResposta5;
    private RadioGroup rdgRespostas5;
    private RadioButton rdbMexico, rdbAustralia, rdbCoreais, rdbNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnResposta5 = findViewById(R.id.btnResposta5);
        rdgRespostas5 = findViewById(R.id.rdgRespostas5);
        rdbMexico = findViewById(R.id.rdbMexico);
        rdbAustralia = findViewById(R.id.rdbAustralia);
        rdbCoreais = findViewById(R.id.rdbCoreias);
        rdbNew = findViewById(R.id.rdbNew);

        btnResposta5.setEnabled(false);

        rdgRespostas5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta5.setEnabled(true);
                }else{
                    btnResposta5.setEnabled(false);
                }
            }
        });
        btnResposta5.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta5(v);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // não chame o super desse método

    }

    public void resposta5(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas5.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbCoreias) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais6.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();

    }
}