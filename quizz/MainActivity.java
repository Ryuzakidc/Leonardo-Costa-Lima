package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public EditText getEdtNome() {
        return edtNome;
    }

    public void setEdtNome(EditText edtNome) {
        edtNome = edtNome;
    }

    private EditText edtNome;
    private Button btnIniciar;
    private Button btnSair;

    public String getNome() {
        return nome;
    }

    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNome = findViewById(R.id.edtNome);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);
        nome = edtNome.getText().toString();

        edtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    verificar();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        verificar();
    }


    public void verificar(){
        String nome = edtNome.getText().toString().trim();
        btnIniciar.setEnabled(!nome.isEmpty());
    }

    public void iniciar(View view){
        nome = edtNome.getText().toString();
        Intent it =  new Intent(this, Pais1.class);
        it.putExtra("Nome",nome);
        startActivity(it);
        finish();
    }

    public void Sair(View view){
        Intent it = new Intent(this, MainActivity.class);
            finish();
    }
}