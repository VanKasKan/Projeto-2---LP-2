package Objetos;

import java.util.Scanner;

public class CrudLocais {

    private RepositorioLocais repositorio;
    private Scanner sc = new Scanner(System.in);

    public CrudLocais(RepositorioLocais repositorio) {
        this.repositorio = repositorio;
    }

    

    public void executar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== CRUD DE LOCAIS ===");
            System.out.println("1 - Listar locais");
            System.out.println("2 - Adicionar local");
            System.out.println("3 - Editar local");
            System.out.println("4 - Remover local");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> listar();
                case 2 -> adicionar();
                case 3 -> editar();
                case 4 -> remover();
                case 0 -> System.out.println("Voltando...");
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
            System.out.println(i + " - " + locais.get(i).getNome()
                    + " (" + locais.get(i).getClass().getSimpleName() + ")");
        }
    }

    public void adicionar() {
        try {
            System.out.println("\n--- Adicionar Local ---");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Descrição: ");
            String desc = sc.nextLine();

            Local local = criarLocalPorTipo(nome, desc);
            repositorio.adicionar(local);

            System.out.println("Local adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar() {
        listar();
        try {
            System.out.print("\nDigite o índice para editar: ");
            int index = Integer.parseInt(sc.nextLine());

            System.out.print("Novo nome: ");
            String novoNome = sc.nextLine();

            System.out.print("Nova descrição: ");
            String novaDesc = sc.nextLine();

            Local novoLocal = criarLocalPorTipo(novoNome, novaDesc);
            repositorio.substituir(index, novoLocal);

            System.out.println("Local atualizado!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public  void remover() {
        listar();
        try {
            System.out.print("\nÍndice para remover: ");
            int index = Integer.parseInt(sc.nextLine());

            repositorio.remover(index);

            System.out.println("Local removido!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private Local criarLocalPorTipo(String nome, String desc) {
        System.out.println("\nSelecione o tipo do local:");
        System.out.println("1 - LocalChatissimo");
        System.out.println("2 - LocalBarulhento");
        System.out.println("3 - LocalQuieto");
        System.out.println("4 - LocalRomantico");
        System.out.println("5 - LocalTreino");
        System.out.print("Escolha: ");

        int tipo = Integer.parseInt(sc.nextLine());

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
