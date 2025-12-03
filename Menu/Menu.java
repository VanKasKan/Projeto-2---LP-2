package Menu;
import java.io.*;

import Objetos.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private boolean modoEscuro;



    public boolean isModoEscuro() {
        return modoEscuro;
    }

    public Menu(){
        setModoEscuro(false);
    }

    public int processaToken(int i, int j){
        Scanner sc = new Scanner(System.in);

        while (true){
            try {
                int tk;
                System.out.print("Opção: ");
                tk = sc.nextInt();
                sc.nextLine();

                if(tk < i || tk > j){

                    System.out.print("\nOpção inválida\n");

                } else {

                    return tk;

                }

            } catch(InputMismatchException e) {

                System.out.print("\nOpção inválida\n");
                sc.nextLine();

            }
        }
    }

    public void setModoEscuro(boolean modoEscuro) {
        this.modoEscuro = modoEscuro;
    }

    public ArrayList<Usuario> carregaLogins() throws IOException, ClassNotFoundException{

        ArrayList<Usuario> usuarios;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dados/Logins.bin"));

        usuarios = (ArrayList<Usuario>) ois.readObject();

        return usuarios;
    }

    public Usuario efetuaLogin(ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.print("\n===============\n[0] Voltar\nLogin: ");
            String login = sc.next();

            if(login.equals("0")){
                System.out.print("\nVoltando para o menu principal...\n");
                return null;

            }

            System.out.print("\n");

            for (Usuario usuarioDaLista : usuarios) {

                if (usuarioDaLista.verificaLogin(login)) {

                    while (true) {

                        System.out.print("\nSenha: ");
                        String senha = sc.next();

                        if (senha.equals("0")) {
                            System.out.print("\nVoltando para o menu principal...\n");
                             return null;
                        }

                        System.out.print("\n");

                        if (usuarioDaLista.verificaSenha(senha)) {

                            System.out.print("\nAbrindo usuário...\n");

                            System.out.print("\n===============\n");
                            return usuarioDaLista;

                        } else {

                            System.out.print("\nSenha incorreta!\n");

                        }

                    }

                } else if(usuarioDaLista == usuarios.getLast()){
                    System.out.print("\nLogin não encontrado\n");
                }
            }

        }

    }

    public void criaPersonagem(ArrayList<PersonagensGerais> personagens, Usuario usuarioAtual){
        Scanner sc = new Scanner(System.in);

        System.out.print("\n===============\n");
        System.out.print("\n[0] Sair\n");

        System.out.print("\nNome do personagem: ");

        String nomePersonagem = sc.next();
        sc.nextLine();

        if (nomePersonagem.equals("0")) {
            System.out.print("\n===============\n");
            return;
        }
        System.out.print("\n===============\n");

        System.out.print("\n===============\n\nArquétipo do personagem\n");

        System.out.print("\n[ 1] Estudioso  [ 2] Amnesico             [ 3] Herdeiro    [ 4] Eremita      [ 5] Atleta");
        System.out.print("\n[ 6] Operário   [ 7] Conselho estudantil  [ 8] Artista     [ 9] Delinquente  [10] Soltario");
        System.out.print("\n[11] Religioso  [12] Potencia             [13] Peso morto  [14] Popular      [15] Capeta");
        System.out.print("\n[16] Obstinado  [17] Sortudo              [18] Vilão       [19] Generica      [0] Sair\n");
        System.out.print("\n===============\n");


        int arquetipo = processaToken(0, 19);

        if(arquetipo == 0){

            return;

        }

        System.out.print("\n===============\n\nTrabalho\n[1] Estudante\n[2] Professor\n[0] Sair\n\n===============\n");
        int trabalho = processaToken(0, 2);

        if(trabalho == 0){

            return;

        } else if(trabalho == 1){

            System.out.print("\n===============\n\nInteresse\n\n[1] Artes Marciais\n[2] Astrologia\n[3] Honkai\n[4] História\n[5] Investimentos\n[0] Sair\n\n===============\n");
            int interesse = processaToken(0, 5);

            if (interesse != 0) {

                Estudante estudante = new Estudante(interesse, nomePersonagem, arquetipo);
                usuarioAtual.addPersoinLista(estudante);
                System.out.print("\nEstudante criado com sucesso\n");

            }

            return;
        } else {

            System.out.print("\n===============\n\nÁrea\n[1] Luta\n[2] Português\n[3] Língua estrangeira\n[4] Estratégia\n[5] História\n[0] Sair\n\n===============\n");
            int area = processaToken(0, 5);

            if (area != 0) {

                Professor professor = new Professor(area, nomePersonagem, arquetipo);
                usuarioAtual.addPersoinLista(professor);
                System.out.print("\nProfessor criado com sucesso!\n");

            }

            return;
        }
    }

    public ObjectOutputStream criaPastaLogins() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dados/Logins.bin"));
        return oos;

    }

}
