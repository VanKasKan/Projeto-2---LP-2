import Objetos.*;

import java.util.Scanner;

public class TestePersonagem {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Personagem fichaDePersonagem;

        System.out.println("Bem vindo ao criador de ficha!");

        System.out.println("\nEscolha o nome do personagem");

        String nome = sc.nextLine();
        
        System.out.println("\nEscolha o Arquétipo do personagem");

        String arquetipoString = null;
        String arquetipo = "default";
        while (arquetipoString == null) {
            System.out.println("1 - Estudioso\n2 - Amnesico\n3 - Herdeiro\n4 - Eremita\n5 - Atleta\n6 - Operario\n7 - Conselho Estudantil\n8 - Artista\n9 - Delinquente\n10 - Solitario\n11 - Religioso\n12 - Potencia\n13 - Peso Morto\n14 - Popular\n15 - Capeta\n16 - Obstinado\n17 - Sortudo\n18 - Vilão\n19 - Genérico\n");
            arquetipoString = sc.nextLine();
            int escolhaInteresse = sc.nextInt();
            switch (escolhaInteresse) {
                case 1:
                    arquetipo = "Estudioso";
                    break;
                case 2:
                    arquetipo = "Amnesico";
                    break;
                case 3:
                    arquetipo = "Herdeiro";
                    break;
                case 4:
                    arquetipo = "Eremita";
                    break;
                case 5:
                    arquetipo = "Atleta";
                    break;
                case 6:
                    arquetipo = "Operario";
                    break;
                case 7:
                    arquetipo = "Conselho_estudantil";
                    break;
                case 8:
                    arquetipo = "Artista";
                    break;
                case 9:
                    arquetipo = "Delinquente";
                    break;
                case 10:
                    arquetipo = "Solitario";
                    break;  
                case 11:
                    arquetipo = "Religioso";
                    break;
                case 12:
                    arquetipo = "Potencia";
                    break;
                case 13:
                    arquetipo = "Pesomorto";
                    break;
                case 14:
                    arquetipo = "Popular";
                    break;
                case 15:
                    arquetipo = "Capeta";
                    break;
                case 16:
                    arquetipo = "Obstinado";
                    break;
                case 17:
                    arquetipo = "Sortudo";
                    break;
                case 18:
                    arquetipo = "Vilao";
                    break;
                case 19:
                    arquetipo = "Generica";
                    break;       
                default:
                    System.out.println("Essa opção não existe! Escolha uma correta\n");
            }
        }
        
        System.out.println("Qual a sociabilidade do personagem de 0 a 100");

        int sociabilidade = sc.nextInt();

        int escolhaTipo = 0;

        System.out.println("O personagem é Estudante, Professor ou algum Extra?");
        while (escolhaTipo != 1 && escolhaTipo !=2 && escolhaTipo !=3) {
        System.out.println("1 - Estudante\n2 - Professor\n3 - Extra");

        escolhaTipo = sc.nextInt();
        switch (escolhaTipo) {
            case 1:
                System.out.println("Qual a área de interesse do Estudante?");
                Interesses interesses = null;
                while (interesses == null) {
                    System.out.println("1 - Artes Marciais\n2 - Historia\n3 - Astrologia\n4 - Honkai\n5 - Investimentos");
                    int escolhaInteresse = sc.nextInt();
                    switch (escolhaInteresse) {
                        case 1:
                            interesses = Interesses.ARTESMARCIAIS;
                            break;
                        case 2:
                            interesses = Interesses.HISTORIA;
                            break;
                        case 3:
                            interesses = Interesses.ASTROLOGIA;
                            break;
                        case 4:
                            interesses = Interesses.HONKAI;
                            break;
                        case 5:
                            interesses = Interesses.INVESTIMENTOS;
                            break;                    
                        default:
                            System.out.println("Essa opção não existe! Escolha uma correta\n");
                    }
                }

                fichaDePersonagem = new Estudante(interesses, nome, Arquetipo.valueOf(arquetipo), sociabilidade, Trabalho.valueOf("ESTUDANTE"));
                break;

            case 2:
                System.out.println("Qual a área acadêmica do Professor?");
                Area area = null;
                while (area == null) {
                    System.out.println("1 - Estratégia\n2 - História\n3 - Lingua Estrangeira\n4 - Luta\n5 - Portugues");
                    int escolhaInteresse = sc.nextInt();
                    switch (escolhaInteresse) {
                        case 1:
                            area = Area.ESTRATEGIA;
                            break;
                        case 2:
                            area = Area.HISTORIA;
                            break;
                        case 3:
                            area = Area.LINGUA_ESTRANGEIRA;
                            break;
                        case 4:
                            area = Area.LUTA;
                            break;
                        case 5:
                            area = Area.PORTUGUES;
                            break;                    
                        default:
                            System.out.println("Essa opção não existe! Escolha uma correta\n");
                    }
                }

                fichaDePersonagem = new Professor(area, nome, Arquetipo.valueOf(arquetipo), sociabilidade, Trabalho.valueOf("PROFESSOR"));
                break;
            case 3:
                System.out.println("Qual a área acadêmica do Professor?");
                Trabalho trabalho = null;
                while (trabalho == null) {
                    System.out.println("1 - Coordenador\n2 - Cozinheiro\n3 - Enfermeiro\n4 - Zelador\n5 - Extra");
                    int escolhaInteresse = sc.nextInt();
                    switch (escolhaInteresse) {
                        case 1:
                            trabalho = Trabalho.COORDENADOR;
                            break;
                        case 2:
                            trabalho = Trabalho.COZINHEIRO;
                            break;
                        case 3:
                            trabalho = Trabalho.ENFERMEIRO;
                            break;
                        case 4:
                            trabalho = Trabalho.ZELADOR;
                            break;
                        case 5:
                            trabalho = Trabalho.EXTRA;
                            break;                    
                        default:
                            System.out.println("Essa opção não existe! Escolha uma correta\n");
                    }
                }

                fichaDePersonagem = new Pessoa(nome, Arquetipo.valueOf(arquetipo), sociabilidade, Trabalho.valueOf("PROFESSOR"));
                break;            
            default:
                System.out.println("Essa opção não existe! Escolha um entre as opções.\n");
                break;
        }
    }
}
}