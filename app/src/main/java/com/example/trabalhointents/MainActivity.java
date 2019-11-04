package com.example.trabalhointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int cadastrar = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private BD bancodedados = new BD();

    public void cadastrar(View view){
        Intent objetoIntent = new Intent(MainActivity.this, Cadastro.class);
        objetoIntent.putExtra("requestCode", cadastrar);
        startActivityForResult(objetoIntent, cadastrar);
    }
    public void login(View view){
        EditText etcpf = findViewById(R.id.et_nomeInicio);
        EditText etsenha = findViewById(R.id.et_senhaInicio);
        String cpf = etcpf.getText().toString();
        String senha = etsenha.getText().toString();
        Usuario credenciado = bancodedados.credenciar(cpf, senha);
        if(credenciado != null){
            Intent logado = new Intent(MainActivity.this, Entrar.class);
            logado.putExtra("nome", credenciado.getNome());
            logado.putExtra("cpf", credenciado.getCpf());
            logado.putExtra("curso", credenciado.getCurso());
            logado.putExtra("senha", credenciado.getSenha());
            startActivity(logado);
        }else{
            TextView mensagem = findViewById(R.id.tvMensagem);
            mensagem.setText("Usuario ou senha incorretos!");
        }
    }
    // Recebe os dados da outra Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // Verfica se o requestCode é o mesmo que foi passado
        if(requestCode==cadastrar/* && resultCode == RESULT_OK*/){
            String nome = data.getStringExtra("nome");
            String cpf = data.getStringExtra("cpf");
            String curso = data.getStringExtra("curso");
            String senha = data.getStringExtra("senha");

            Usuario novo = new Usuario(nome, cpf, curso, senha);
            TextView mostraMsg = findViewById(R.id.tvMensagem);
            //mostraMsg.setText("Nome: "+nome+" / CPF: "+cpf+"/ Senha: "+senha+"\n");
            bancodedados.cadastrarUsuario(novo);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}
