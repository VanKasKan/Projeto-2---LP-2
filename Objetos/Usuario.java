package Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String login;
    private String senha;
    ArrayList<Personagem> personagens;
    Scanner sc = new Scanner(System.in);

    public Usuario(String login, String senha){
        setLogin(login);
        setSenha(senha);

        personagens = null;
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

    public void imprimeLogin(){
        System.out.print("\nLogin: "+getLogin()+"\n");
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

    public void modificarSenha(){
        while (true){

            System.out.print("\n[1] Sair\nSenha atual: ");

            String senha = sc.next();

            if(senha.equals("1")){
                break;
            }
            if(verificaSenha(senha)){

                System.out.print("\nDigite a sua nova senha: ");
                String novaSenha = sc.next();

                setSenha(novaSenha);
                System.out.print("\nSenha atualizada com sucesso!\n");
                break;

            } else {

                System.out.print("\nSenha incorreta!\n");

            }

        }

    }

    public void modificarLogin(){
        while (true){

            System.out.print("\n[1] Sair\nSenha: ");

            String senha = sc.next();

            if(senha.equals("1")){
                break;
            }
            if(verificaSenha(senha)){

                System.out.print("\nNovo login: ");
                String novoLogin = sc.next();

                setLogin(novoLogin);
                System.out.print("\nLogin atualizado com sucesso!\n");
                break;

            } else {

                System.out.print("\nSenha incorreta!\n");

            }

        }
    }

}
