import Objetos.*;
import Menu.Menu;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc, opc2;
        Menu opMenu = new Menu();
        ArrayList<Usuario> usuarios = null;
        Path caminho = Paths.get("Dados/Logins.bin");
        Usuario usuarioAtual = null;

        System.out.print("\n===============\nBem-vindo(a)\n===============\n");

        while (true) {

            System.out.print("\n===============\n");
            System.out.print("\n[1] Entrar\n[2] Cadastrar-se\n[3] Configurações\n[0] Sair\n");
            System.out.print("\n===============\n");

            opc = opMenu.processaToken(0, 3);

            if (opc == 0) {
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

            if (opc == 1) {
                if (usuarios == null) {
                    if (Files.exists(caminho)) {
                        System.out.print("\nCarregando logins...\n");

                        try {
                            usuarios = opMenu.carregaLogins();
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.print("\nNão há logins, cadastre-se!\n");
                        }

                        if (usuarios != null) {
                            usuarioAtual = opMenu.efetuaLogin(usuarios);
                        }
                    }
                } else {
                    usuarioAtual = opMenu.efetuaLogin(usuarios);
                }

            } else if (opc == 2) {
                Usuario user;

                while (true) {

                    if (usuarios == null) {
                        System.out.print("\nCarregando logins...\n");

                        try {
                            usuarios = opMenu.carregaLogins();
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.print("\nNão há logins carregados...\nCriando nova lista de logins...\n");
                        }

                        System.out.print("\n===============\n\n[0] Sair\nNovo cadastro\n");
                        System.out.print("\nLogin: ");
                        String login = sc.next();

                        if (login.equals("0")) break;

                        System.out.print("\nSenha: ");
                        String senha = sc.next();

                        System.out.print("\n===============\n");

                        if (senha.equals("0")) break;

                        user = new Usuario(login, senha);
                        usuarios = new ArrayList<>();

                    } else {
                        System.out.print("\n===============\n\n[0] Sair\nNovo cadastro\n");
                        System.out.print("\nLogin: ");
                        String login = sc.next();

                        if (login.equals("0")) break;

                        System.out.print("\nSenha: ");
                        String senha = sc.next();

                        System.out.print("\n===============\n");

                        if (senha.equals("0")) break;

                        user = new Usuario(login, senha);
                    }

                    usuarios.add(user);
                    System.out.print("\nUsuário criado!\n\nLogue para jogar!\n");
                    break;
                }

            } else {
                int drkLght;

                while (true) {
                    if (opMenu.isModoEscuro()) {
                        System.out.print("\n===============\n[1] Modo claro\n[0] Voltar\n===============\n");
                        drkLght = opMenu.processaToken(0, 1);

                        if (drkLght == 0) break;
                        else {
                            opMenu.setModoEscuro(false);
                            System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");
                        }

                    } else {
                        System.out.print("\n===============\n[1] Modo escuro\n[0] Voltar\n===============\n");
                        drkLght = opMenu.processaToken(0, 1);

                        if (drkLght == 0) break;
                        else {
                            opMenu.setModoEscuro(true);
                            System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");
                        }
                    }
                }
            }

            if (usuarioAtual != null) {

                while (true) {

                    int encerra = -1;
                    // Se não houver personagens
                    if (usuarioAtual.getPersonagens() == null || usuarioAtual.getPersonagens().isEmpty()) {

                        System.out.print("\n===============\n[1] Criar novo personagem\n[2] Configurações\n[3] Gerenciar locais\n[0] Voltar ao menu principal\n===============\n");
                        opc2 = opMenu.processaToken(0, 3);

                        if (opc2 == 0) {
                            usuarioAtual = null;
                            break;

                        } else if (opc2 == 1) {
                            opMenu.criaPersonagem(usuarioAtual.getPersonagens(), usuarioAtual);

                        } else if (opc2 == 3) {
                            if (usuarioAtual.getLocais() == null) {
                                usuarioAtual.setLocais(new RepositorioLocais());
                            }
                            CrudLocais crudLocais = new CrudLocais(usuarioAtual.getLocais());
                            crudLocais.executar();

                        } else { // Configurações
                            int drkLght;

                            while (true) {
                                if (opMenu.isModoEscuro()) {
                                    System.out.print("\n===============\n[1] Modo claro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                    drkLght = opMenu.processaToken(0, 2);

                                    if (drkLght == 0) break;
                                    else if (drkLght == 2) {
                                        System.out.print("\n===============\n");
                                        usuarioAtual.imprimeLogin();
                                        System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                        int opcao = opMenu.processaToken(0, 2);

                                        if (opcao == 0) break;
                                        else if (opcao == 2) usuarioAtual.modificarSenha();
                                        else usuarioAtual.modificarLogin();

                                    } else {
                                        opMenu.setModoEscuro(false);
                                        System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");
                                    }

                                } else {
                                    System.out.print("\n===============\n[1] Modo escuro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                    drkLght = opMenu.processaToken(0, 2);

                                    if (drkLght == 0) break;
                                    else if (drkLght == 2) {
                                        System.out.print("\n===============\n");
                                        usuarioAtual.imprimeLogin();
                                        System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                        int opcao = opMenu.processaToken(0, 2);

                                        if (opcao == 0) break;
                                        else if (opcao == 2) usuarioAtual.modificarSenha();
                                        else usuarioAtual.modificarLogin();

                                    } else {
                                        opMenu.setModoEscuro(true);
                                        System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");
                                    }
                                }
                            }
                        }

                    } else if (usuarioAtual.getPersonagens().size() < 10) {
                        // Menu principal com personagens



                        //se nao tiver locais
                        while (true) {

                            if (usuarioAtual.getLocais() == null) {

                                while(true){
                                    System.out.print("\n===============\n[1] Criar novo personagem\n[2] Lista de personagens\n[3] Gerenciar locais\n[4] Configurações\n[0] Voltar ao menu principal\n===============\n");
                                    opc2 = opMenu.processaToken(0, 4);

                                    if (opc2 == 0) {

                                        encerra = 0;
                                        break;

                                    } else if (opc2 == 1) {

                                        if(usuarioAtual.getPersonagens().size() >= 10){
                                            System.out.print("\nNúmero de personagens excedido!\n");
                                            continue;
                                        }

                                        opMenu.criaPersonagem(usuarioAtual.getPersonagens(), usuarioAtual);

                                    } else if (opc2 == 2) {

                                        while (true) {

                                            usuarioAtual.imprimePersonagens();

                                            System.out.print("\n[0] Sair\n");

                                            int index = opMenu.processaToken(0, usuarioAtual.getPersonagens().size());

                                            if (index == 0) {

                                                break;
                                            }

                                            if (usuarioAtual.isEstudante(index)) {

                                                System.out.print("\n===============\n[1] Deletar\n[2] Exibir informações\n[3] Alterar nome\n[4] Alterar arquétipo\n[5] Alterar interesse\n[0] Sair\n===============\n");

                                            } else {

                                                System.out.print("\n===============\n[1] Deletar\n[2] Exibir informações\n[3] Alterar nome\n[4] Alterar arquétipo\n[5] Alterar área\n[0] Sair\n===============\n");

                                            }

                                            int alteracao = opMenu.processaToken(0, 5);
                                            if (alteracao == 0) break;

                                            usuarioAtual.alteraListaPersonagens(alteracao, index);
                                        }

                                    } else if (opc2 == 3) {

                                        if (usuarioAtual.getLocais() == null) {

                                            usuarioAtual.setLocais(new RepositorioLocais());

                                        }
                                        CrudLocais crudLocais = new CrudLocais(usuarioAtual.getLocais());
                                        crudLocais.executar();

                                        if(usuarioAtual.getLocais() != null){
                                            break;

                                        }

                                    } else {
                                        int drkLght;

                                        while (true) {
                                            if (opMenu.isModoEscuro()) {
                                                System.out.print("\n===============\n[1] Modo claro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                                drkLght = opMenu.processaToken(0, 2);

                                                if (drkLght == 0) break;
                                                else if (drkLght == 2) {
                                                    System.out.print("\n===============\n");
                                                    usuarioAtual.imprimeLogin();
                                                    System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                                    int opcao = opMenu.processaToken(0, 2);

                                                    if (opcao == 0) break;
                                                    else if (opcao == 2) usuarioAtual.modificarSenha();
                                                    else usuarioAtual.modificarLogin();

                                                } else {
                                                    opMenu.setModoEscuro(false);
                                                    System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");
                                                }

                                            } else {
                                                System.out.print("\n===============\n[1] Modo escuro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                                drkLght = opMenu.processaToken(0, 2);

                                                if (drkLght == 0) break;
                                                else if (drkLght == 2) {
                                                    System.out.print("\n===============\n");
                                                    usuarioAtual.imprimeLogin();
                                                    System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                                    int opcao = opMenu.processaToken(0, 2);

                                                    if (opcao == 0) break;
                                                    else if (opcao == 2) usuarioAtual.modificarSenha();
                                                    else usuarioAtual.modificarLogin();

                                                } else {
                                                    opMenu.setModoEscuro(true);
                                                    System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");
                                                }
                                            }
                                        }

                                    }
                                }


                            }
                            if(encerra == 0){
                                break;
                            }

                            System.out.print("\n===============\n[1] Criar novo personagem\n[2] Lista de personagens\n[3] Gerenciar locais\n[4] Configurações\n[5] Jogar\n[0] Voltar ao menu principal\n===============\n");
                            opc2 = opMenu.processaToken(0, 5);

                            if (opc2 == 0) {
                                encerra = 0;
                                break;

                            } else if (opc2 == 1) {
                                opMenu.criaPersonagem(usuarioAtual.getPersonagens(), usuarioAtual);

                            } else if (opc2 == 2) {
                                while (true) {
                                    usuarioAtual.imprimePersonagens();
                                    System.out.print("\n[0] Sair\n");
                                    int index = opMenu.processaToken(0, usuarioAtual.getPersonagens().size());
                                    if (index == 0) break;

                                    if (usuarioAtual.isEstudante(index)) {
                                        System.out.print("\n===============\n[1] Deletar\n[2] Exibir informações\n[3] Alterar nome\n[4] Alterar arquétipo\n[5] Alterar interesse\n[0] Sair\n===============\n");
                                    } else {
                                        System.out.print("\n===============\n[1] Deletar\n[2] Exibir informações\n[3] Alterar nome\n[4] Alterar arquétipo\n[5] Alterar área\n[0] Sair\n===============\n");
                                    }

                                    int alteracao = opMenu.processaToken(0, 5);
                                    if (alteracao == 0) continue;

                                    usuarioAtual.alteraListaPersonagens(alteracao, index);
                                }

                            } else if (opc2 == 3) {
                                if (usuarioAtual.getLocais() == null) {
                                    usuarioAtual.setLocais(new RepositorioLocais());
                                }
                                CrudLocais crudLocais = new CrudLocais(usuarioAtual.getLocais());
                                crudLocais.executar();

                            } else if (opc2 == 5) {

                                if(usuarioAtual.getPersonagens().isEmpty() || usuarioAtual.getLocais().isempty()){
                                    System.out.print("\nVerifique as listas de locais e personagens, há algo faltando...\n");
                                    continue;
                                }

                                System.out.print("\n===============\nEscolha o número de vezes que será o jogo rodará entre 1 a 10 vezes\n===============\n");
                                int index = opMenu.processaToken(1, 10);
                                LogicaJogo.limparTerminal();
                                LogicaJogo.selecionarModo(index, usuarioAtual.getPersonagens(), usuarioAtual.getLocais());

                            } else { // Configurações
                                int drkLght;

                                while (true) {
                                    if (opMenu.isModoEscuro()) {
                                        System.out.print("\n===============\n[1] Modo claro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                        drkLght = opMenu.processaToken(0, 2);

                                        if (drkLght == 0) break;
                                        else if (drkLght == 2) {
                                            System.out.print("\n===============\n");
                                            usuarioAtual.imprimeLogin();
                                            System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                            int opcao = opMenu.processaToken(0, 2);

                                            if (opcao == 0) break;
                                            else if (opcao == 2) usuarioAtual.modificarSenha();
                                            else usuarioAtual.modificarLogin();

                                        } else {
                                            opMenu.setModoEscuro(false);
                                            System.out.print("\n===============\n\nModo claro ativado\n\n===============\n");
                                        }

                                    } else {
                                        System.out.print("\n===============\n[1] Modo escuro\n[2] Configurações da conta\n[0] Voltar\n===============\n");
                                        drkLght = opMenu.processaToken(0, 2);

                                        if (drkLght == 0) break;
                                        else if (drkLght == 2) {
                                            System.out.print("\n===============\n");
                                            usuarioAtual.imprimeLogin();
                                            System.out.print("\n[1] Alterar login\n[2] Alterar senha\n[0] Voltar\n");
                                            int opcao = opMenu.processaToken(0, 2);

                                            if (opcao == 0) break;
                                            else if (opcao == 2) usuarioAtual.modificarSenha();
                                            else usuarioAtual.modificarLogin();

                                        } else {
                                            opMenu.setModoEscuro(true);
                                            System.out.print("\n===============\n\nModo escuro ativado\n\n===============\n");
                                        }
                                    }
                                }
                            }
                        }

                        usuarioAtual = null;
                        break;


                    }
                }
            }
        }
    }
}