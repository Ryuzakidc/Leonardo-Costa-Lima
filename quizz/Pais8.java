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

public class Pais8 extends AppCompatActivity {

    private Button btnResposta8;
    private RadioGroup rdgRespostas8;
    private RadioButton rdbHungria, rdbHolanda, rdbHong, rdbIrlanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta8 = findViewById(R.id.btnResposta8);
        rdgRespostas8 = findViewById(R.id.rdgRespostas8);
        rdbHungria = findViewById(R.id.rdbHungria);
        rdbHolanda = findViewById(R.id.rdbHolanda);
        rdbHong = findViewById(R.id.rdbHong);
        rdbIrlanda = findViewById(R.id.rdbIrlanda);

        btnResposta8.setEnabled(false);

        rdgRespostas8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta8.setEnabled(true);
                }else{
                    btnResposta8.setEnabled(false);
                }
            }
        });
        btnResposta8.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta8(v);
            }
        });


    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }
    public void resposta8(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas8.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbHungria) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais9.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }
}