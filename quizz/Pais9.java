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


public class Pais9 extends AppCompatActivity {



    private Button btnResposta9;
    private RadioGroup rdgRespostas9;
    private RadioButton rdbAlemanha, rdbItalia, rdbJamaica, rdbCaribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResposta9 = findViewById(R.id.btnResposta9);
        rdgRespostas9 = findViewById(R.id.rdgRespostas9);
        rdbAlemanha = findViewById(R.id.rdbAlemanha);
        rdbItalia = findViewById(R.id.rdbItalia);
        rdbJamaica = findViewById(R.id.rdbCaribe);

        btnResposta9.setEnabled(false);

        rdgRespostas9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkdId) {
                if(checkdId != -1){
                    btnResposta9.setEnabled(true);
                }else{
                    btnResposta9.setEnabled(false);
                }
            }
        });
        btnResposta9.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                resposta9(v);
            }
        });


    }
    @Override
    public void onBackPressed() {
        // não chame o super desse método
    }
    public void resposta9(View view) {
        String nome = getIntent().getStringExtra("Nome");
        int acertos = rdgRespostas9.getCheckedRadioButtonId();
        Intent intent = getIntent();
        int certosAnt = getIntent().getIntExtra("Certos", 0);
        if (acertos == R.id.rdbItalia) {
            certosAnt++;
            Toast.makeText(this, "Você Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você Errou!", Toast.LENGTH_SHORT).show();
        }
        Intent it = new Intent(this, Pais10.class);
        it.putExtra("Certos", certosAnt);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }
}