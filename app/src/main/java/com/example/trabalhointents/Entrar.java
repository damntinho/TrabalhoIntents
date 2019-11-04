package com.example.trabalhointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Entrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        TextView bv = findViewById(R.id.tvBoasVindas);
        String nome, cpf, curso;
        Intent logado = getIntent();
        nome = logado.getStringExtra("nome");
        cpf = logado.getStringExtra("cpf");
        curso = logado.getStringExtra("curso");
        bv.setText("Seja bem-vindo "+nome+"!\nSUAS INFORMAÇÕES:\nSeu cpf é: "+cpf+"\nSeu curso: "+curso+"\n");
    }
}
