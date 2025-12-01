import Objetos.*;
import Menu.Menu;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc;
        Menu opMenu = new Menu();
        ArrayList<Usuario> usuarios = null;
        Path caminho = Paths.get("Dados/Logins.bin");
        Usuario usuarioAtual = null;

        System.out.print("\n===============\nBem-vindo(a)\n===============\n");
        while (true){

            if(usuarioAtual == null){

            }
            System.out.print("\n===============\n");
            System.out.print("\n[1] Entrar\n[2] Cadastrar-se\n[3] Configurações\n[0] Sair\n");
            System.out.print("\n===============\n");

            opc = opMenu.processaToken(0, 3);


            if(opc == 0){
                System.out.print("Salvando logins...\n");

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dados/Logins.bin"))) {
                    oos.writeObject(usuarios);
                    System.out.println("Todos os usuários foram salvos no arquivo\nEncerrando...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Até logo!");
                break;
            }

            if(opc == 1){

                if(usuarios == null) {

                    if (Files.exists(caminho)) {

                        System.out.print("\nCarregando logins...\n");

                        try {

                            usuarios = opMenu.carregaLogins();

                        } catch (IOException | ClassNotFoundException e) {

                            System.out.print("\nNão há logins, cadastre-se!\n");

                        }
                        if(usuarios != null){
                            while(true){

                                System.out.print("\n===============\nLogin (v para voltar): ");
                                String login = sc.next();

                                if(login.equals("v")){

                                    break;

                                }

                                System.out.print("\n");

                                boolean achou = false;

                                for (Usuario usuario : usuarios) {

                                    if (usuario.verificaLogin(login)) {
                                        achou = true;

                                        while (true) {

                                            System.out.print("\nSenha (v para voltar): ");
                                            String senha = sc.next();

                                            if (senha.equals("v")) {
                                                break;
                                            }

                                            System.out.print("\n");

                                            if (usuario.verificaSenha(senha)) {

                                                usuarioAtual = usuario;
                                                System.out.print("\nAbrindo usuário...\n");

                                                System.out.print("\n===============\n");
                                                break;

                                            } else {

                                                System.out.print("\nSenha incorreta!\n");

                                            }

                                        }

                                        break;

                                    }
                                }

                                if (!achou){
                                    System.out.print("\nLogin não encontrado!\n");

                                    continue;
                                }

                                break;
                            }
                        }
                    }



                } else {

                    while(true){

                        System.out.print("\n===============\nLogin (v para voltar): ");
                        String login = sc.next();

                        if(login.equals("v")){

                            break;

                        }

                        System.out.print("\n");

                        boolean achou = false;

                        for (Usuario usuario : usuarios) {

                            if (usuario.verificaLogin(login)) {
                                achou = true;

                                while (true) {

                                    System.out.print("\nSenha (v para voltar): ");
                                    String senha = sc.next();

                                    if (senha.equals("v")) {
                                        break;
                                    }

                                    System.out.print("\n");

                                    if (usuario.verificaSenha(senha)) {

                                        usuarioAtual = usuario;
                                        System.out.print("\nAbrindo usuário...\n");

                                        System.out.print("\n===============\n");
                                        break;

                                    } else {

                                        System.out.print("\nSenha incorreta!\n");

                                    }

                                }

                                break;

                            }
                        }

                        if (!achou){
                            System.out.print("\nLogin não encontrado!\n");

                            continue;
                        }

                        break;
                    }
                }


                //entrar

                //continuação do jogo
            } else if(opc == 2){
                Usuario user;

                while(true){

                    if (usuarios == null) {

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

                    }
                    usuarios.add(user);
                    System.out.print("\nUsuário criado!\n\nLogue para jogar!\n");
                    break;

                }

            } else {
                int drkLght;

                if(usuarioAtual == null){

                    while (true){
                        if(opMenu.isModoEscuro()){

                            System.out.print("\n===============\n[1] Modo claro\n[2] Voltar\n===============\n");

                            drkLght = opMenu.processaToken(1, 2);

                            if(drkLght == 2){
                                break;
                            } else {

                                opMenu.setModoEscuro(false);
                                System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");
                            }
                        } else {

                            System.out.print("\n===============\n[1] Modo escuro\n[2] Voltar\n===============\n");

                            drkLght = opMenu.processaToken(1, 2);

                            if(drkLght == 2){
                                break;
                            } else {

                                opMenu.setModoEscuro(true);
                                System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");

                            }
                        }
                    }

                } else {

                    while (true){

                        if(opMenu.isModoEscuro()){
                            System.out.print("\n===============\n[1] Modo claro\n[2] Configurações da conta\n[3] Voltar\n===============\n");

                            drkLght = opMenu.processaToken(1, 3);

                            if(drkLght == 3){
                                break;
                            } else if(drkLght == 2){

                                System.out.print("\n===============\n");
                                usuarioAtual.imprimeLogin();

                                System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[3] Voltar\n");
                                int opcao = opMenu.processaToken(1, 3);

                                if(opcao == 3){
                                    break;
                                } else if(opcao == 2){

                                    usuarioAtual.modificarSenha();

                                } else {

                                    usuarioAtual.modificarLogin();
                                }

                            } else {

                                opMenu.setModoEscuro(false);
                                System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");

                            }
                        } else {
                            System.out.print("\n===============\n[1] Modo escuro\n[2] Configurações da conta\n[3] Voltar\n===============\n");

                            drkLght = opMenu.processaToken(1, 3);

                            if(drkLght == 3){
                                break;
                            } else if(drkLght == 2){

                                System.out.print("\n===============\n");
                                usuarioAtual.imprimeLogin();

                                System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[3] Voltar\n");
                                int opcao = opMenu.processaToken(1, 3);

                                if(opcao == 3){
                                    break;
                                } else if(opcao == 2){

                                    usuarioAtual.modificarSenha();

                                } else {

                                    usuarioAtual.modificarLogin();
                                }

                            } else {

                                opMenu.setModoEscuro(true);
                                System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");

                            }

                        }
                    }


                }

                //altera modo escuro e edita login
            }
        }
    }
}

