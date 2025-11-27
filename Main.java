import Objetos.*;
import Menu.Menu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc;
        Menu opMenu = new Menu();
        ArrayList<Usuario> usuarios = null;
        Path caminho = Paths.get("Dados/Logins.bin");

        System.out.print("\n===============\nBem-vindo(a)\n===============\n");
        while (true){

            System.out.print("\n===============\n");
            System.out.print("\n[1] Entrar\n[2] Cadastrar-se\n[3] Configurações\n[4] Sair\n");
            System.out.print("\n===============\n");

            while(true){
                try{
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if(opc < 1 || opc > 4){
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e){
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }


            if(opc == 4){
                System.out.print("Encerrando...");
                break;
            }

            if(opc == 1){

                Usuario user;

                if(usuarios == null) {

                    if (Files.exists(caminho)) {

                        System.out.print("\nCarregando logins...\n");

                        try {

                            usuarios = opMenu.carregaLogins();

                        } catch (IOException | ClassNotFoundException e) {

                            System.out.print("\nNão há logins, cadastre-se!\n");

                        }

                    }
                } else {
                    boolean termina = false;

                    while(true){

                        System.out.print("\n===============\nLogin (v para voltar): ");
                        String login = sc.next();

                        if(login.equals("v")){

                            break;

                        }

                        System.out.print("\n");


                        for(int i = 0; i < usuarios.size(); i++){

                            if(usuarios.get(i).verificaLogin(login)){

                                while(true){

                                    System.out.print("\nSenha (v para voltar): ");
                                    String senha = sc.next();

                                    if(senha.equals("v")){
                                        termina = true;
                                        break;
                                    }

                                    System.out.print("\n");

                                    if(usuarios.get(i).verificaSenha(senha)){

                                        user = usuarios.get(i);

                                        System.out.print("\n===============\n");
                                        break;

                                    } else {

                                        System.out.print("\nSenha incorreta!\n");

                                    }

                                }

                                if(termina){
                                    break;
                                }

                            } else if(i++ == usuarios.size()){

                                System.out.print("\nLogin não encontrado!\n");

                            }
                        }

                        if(termina){

                            break;

                        }
                    }
                }


                //entrar

                //continuação do jogo
            } else if(opc == 2){
                Usuario user;

                while(true){

                    if (usuarios == null) {

                        if(!Files.exists(caminho)) {

                            try {

                                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dados/Logins.bin"));

                            } catch (IOException e) {

                                System.out.print("\nErro ao criar o arquivo\n");

                            }
                        }

                        System.out.print("\nCarregando logins...\n");

                        try {

                            usuarios = opMenu.carregaLogins();

                        } catch (IOException | ClassNotFoundException e) {

                            System.out.print("\nNão há logins carregados...\nCriando nova lista de logins...\n");

                        }

                        System.out.print("\n===============\n\nNovo cadastro (v para voltar)\n");

                        System.out.print("\nLogin: ");

                        String login = sc.next();

                        if(login.equals("v")){

                            break;
                        }

                        System.out.print("\n");

                        System.out.print("\nSenha: ");
                        String senha = sc.next();

                        System.out.print("\n");
                        System.out.print("\n===============\n");

                        if(senha.equals("v")){

                            break;

                        }

                        user = new Usuario(login, senha);
                        usuarios = new ArrayList<>();
                        usuarios.add(user);

                    } else {
                        System.out.print("\n===============\n\nNovo cadastro (v para voltar)\n");

                        System.out.print("\nLogin: ");

                        String login = sc.next();

                        if(login.equals("v")){

                            break;
                        }

                        System.out.print("\n");

                        System.out.print("\nSenha: ");
                        String senha = sc.next();

                        System.out.print("\n");
                        System.out.print("\n===============\n");

                        if(senha.equals("v")){

                            break;

                        }

                        user = new Usuario(login, senha);
                        usuarios.add(user);
                        System.out.print("\nUsuário criado!\n\nLogue para jogar!\n");
                    }

                }

            } else if(opc == 3){
                System.out.print("\nconfigurações\n");
                //altera modo escuro e edita login
            }
        }



        //Personagem jogador = new Estudante(Interesses.valueOf("HONKAI"), "qualquerum", Arquetipo.valueOf("HERDEIRO"), 15, Trabalho.valueOf("ESTUDANTE"));
        //System.out.println(jogador.getNome());
    }
}

