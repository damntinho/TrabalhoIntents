package com.example.trabalhointents;

import java.util.ArrayList;

public class BD {
    private ArrayList usuarios;

    public BD() {
        usuarios = new ArrayList();
    }

    public void cadastrarUsuario(Usuario novo){
        usuarios.add(novo);
    }
    public Usuario credenciar(String cpf, String senha){
        Usuario temp = null;
        int flag = 0;
        for(int usr=0; usr<usuarios.size(); usr++){
            temp = (Usuario) usuarios.get(usr);

            if(temp.getCpf().equals(cpf) && temp.getSenha().equals(senha)){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            return temp;
        }else
        return null;
    }
}
