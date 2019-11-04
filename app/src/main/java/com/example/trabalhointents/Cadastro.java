package com.example.trabalhointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void cadastrarUsuario(View view){
        EditText etnome = findViewById(R.id.et_nomeCadastro);
        String nome = etnome.getText().toString();

        EditText etcpf = findViewById(R.id.et_cpfCadastro);
        String cpf = etcpf.getText().toString();

        EditText etcurso = findViewById(R.id.et_cursoCadastro);
        String curso = etcurso.getText().toString();

        EditText etsenha = findViewById(R.id.et_senhaCadastro);
        String senha = etsenha.getText().toString();

        //Intent backIntent = new Intent(Cadastro.this, MainActivity.class);
        Intent backIntent = new Intent();
        backIntent.putExtra("nome", nome);
        backIntent.putExtra("cpf", cpf);
        backIntent.putExtra("curso", curso);
        backIntent.putExtra("senha", senha);
        setResult(RESULT_OK, backIntent);
        finish();
    }
}
