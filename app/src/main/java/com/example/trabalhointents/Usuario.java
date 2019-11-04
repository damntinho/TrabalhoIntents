package com.example.trabalhointents;

public class Usuario extends Pessoa {
    private String senha;
    private String curso;

    public Usuario(String nome, String cpf,  String curso, String senha) {
        super(nome, cpf);
        this.senha = senha;
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
