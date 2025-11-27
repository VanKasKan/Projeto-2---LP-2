package Objetos;

import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;
    ArrayList<Personagem> personagens;

    private boolean modoEscuro;

    public Usuario(String login, String senha){
        setLogin(login);
        setSenha(senha);

        personagens = null;
        modoEscuro = false;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isModoEscuro() {
        return modoEscuro;
    }

    public boolean verificaLogin(String teste){
        if(teste.equals(login)){
            return true;
        }
        return false;
    }

    public boolean verificaSenha(String teste){
        if(teste.equals(senha)){
            return true;
        }
        return false;
    }

}
