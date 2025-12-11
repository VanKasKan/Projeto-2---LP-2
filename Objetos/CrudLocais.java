package Objetos;

import java.util.Scanner;
import Menu.Menu;

public class CrudLocais {

    private RepositorioLocais repositorio;
    private Scanner sc = new Scanner(System.in);

    public CrudLocais(RepositorioLocais repositorio) {
        this.repositorio = repositorio;
    }

    

    public void executar() {
        Menu token = new Menu();

        while (true) {
            System.out.println("\n=== CRUD DE LOCAIS ===");
            System.out.println("[1] Listar locais");
            System.out.println("[2] Adicionar local");
            System.out.println("[3] Editar local");
            System.out.println("[4] Remover local");
            System.out.println("[0] Voltar");
            System.out.print("\n===============\n");
            int opcao = token.processaToken(0, 4);

            if(opcao == 0){
                return;
            }

            switch (opcao) {
                case 1 -> listar();
                case 2 -> adicionar();
                case 3 -> editar();
                case 4 -> remover();
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    public void listar() {
        System.out.println("\n--- Lista de Locais ---");

        var locais = repositorio.getLocais();

        if(locais == null){
            System.out.println("Nenhum local cadastrado.");
            return;
        }
        if (locais.isEmpty()) {
            System.out.println("Nenhum local cadastrado.");
            return;
        }

        for (int i = 0; i < locais.size(); i++) {
            System.out.println("["+(i+1)+"]" + locais.get(i).getNome()
                    + " (" + locais.get(i).getClass().getSimpleName() + ")");
        }
    }

    public void adicionar() {
        try {
            System.out.println("\n--- Adicionar Local ---");

            System.out.print("\n[0] Voltar\n");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if(nome.equals("0")){
                return;
            }

            System.out.print("Descrição: ");
            String desc = sc.nextLine();

            if(desc.equals("0")){
                return;
            }

            Local local = criarLocalPorTipo(nome, desc);
            if(local == null){
                return;
            }
            repositorio.adicionar(local);

            System.out.println("Local adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar() {
        listar();

        if(repositorio.getLocais() == null){
            return;
        }

        System.out.print("[0] Voltar\n");


        try {

            Menu token = new Menu();
            int index = token.processaToken(0, repositorio.getLocais().size());
            if(index == 0){
                return;
            }

            System.out.print("\n===============\n");
            System.out.print("\n[1] Editar nome\n[2] Editar descrição\n[0]Voltar\n");
            System.out.print("\n===============\n");
            int opcao = token.processaToken(0, 2);

            if(opcao == 0){

                return;

            } else if(opcao == 1){
                System.out.print("\n[0] Voltar");
                System.out.print("\nNovo nome: ");
                String novoNome = sc.nextLine();

                if(novoNome.equals("0")){
                    return;
                }

                repositorio.getLocais().get(index-1).setNome(novoNome);

            } else if(opcao == 2){
                System.out.print("\n[0] Voltar");
                System.out.print("\nNova descrição: ");
                String novaDesc = sc.nextLine();
                if(novaDesc.equals("0")){
                    return;
                }
                repositorio.getLocais().get(index-1).setDescricao(novaDesc);
            }

            System.out.println("Local atualizado!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public  void remover() {
        Menu token = new Menu();
        listar();
        if(repositorio.getLocais() == null){
            return;
        }

        try {
            System.out.print("\n[0] Voltar");
            int index = token.processaToken(0, repositorio.getLocais().size());


            if(index == 0){
                return;
            }

            repositorio.remover(index);

            System.out.println("Local removido!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private Local criarLocalPorTipo(String nome, String desc) {
        Menu token =  new Menu();

        System.out.print("\n===============\n");
        System.out.println("\nSelecione o tipo do local:");
        System.out.println("[1] LocalChatissimo");
        System.out.println("[2] LocalBarulhento");
        System.out.println("[3] LocalQuieto");
        System.out.println("[4] LocalRomantico");
        System.out.println("[5] LocalTreino");
        System.out.println("[0] Voltar");
        System.out.print("\n===============\n");

        int tipo = token.processaToken(0, 5);

        if(tipo == 0){
            return null;
        }

        return switch (tipo) {
            case 1 -> new LocalChatissimo(nome, desc);
            case 2 -> new LocalBarulhento(nome, desc);
            case 3 -> new LocalQuieto(nome, desc);
            case 4 -> new LocalRomantico(nome, desc);
            case 5 -> new LocalTreino(nome, desc);
            default -> throw new IllegalArgumentException("Tipo inválido.");
        };
    }
}
