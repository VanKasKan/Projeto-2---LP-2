package Objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicaJogo {

    private static Random random = new Random();

    public static void executarJogo(ArrayList<PersonagensGerais> arrayPersonagens, RepositorioLocais locais) {
        try {
            for (PersonagensGerais personagem : arrayPersonagens) {
                int evento = selecionarEvento(arrayPersonagens);
                Local local = selecionaLocal(locais);
                PersonagensGerais personagem2;
                PersonagensGerais personagem3;

                switch (evento) {
                    case 1:
                        local.interagirSozinho(personagem);
                        break;
                    case 2:
                        do {
                            int indexPersonagem = random.nextInt(arrayPersonagens.size());
                            personagem2 = arrayPersonagens.get(indexPersonagem);
                        } while (personagem2.equals(personagem));

                        local.interagir2Personagens(personagem, personagem2);
                        break;
                    case 3:
                        do {
                            int indexPersonagem = random.nextInt(arrayPersonagens.size());
                            personagem2 = arrayPersonagens.get(indexPersonagem);
                        } while (personagem2 != personagem);
                        do {
                            int indexPersonagem = random.nextInt(arrayPersonagens.size());
                            personagem3 = arrayPersonagens.get(indexPersonagem);
                        } while (personagem3.equals(personagem) || personagem3.equals(personagem2));

                        local.interagir3Personagens(personagem, personagem2, personagem3);
                        break;
                    default:
                        System.out.println("Personagens insuficientes para rodar um dia...");
                        break;
                }
            }
            return;
    } catch (Exception e) {
        System.out.println("Impossível rodar um dia devido um erro!");
        return;
    }
    }

    public static int selecionarEvento(ArrayList<PersonagensGerais> arrayPersonagens) {
        boolean doisPersonagens = false;
        boolean tresPersonagens = false;
        int qtdPersonagens = arrayPersonagens.size();
        if (qtdPersonagens > 1) {
            doisPersonagens = true;
        }
        if (qtdPersonagens > 2) {
            tresPersonagens = true;
        }

        if (random.nextBoolean()) {
            return 1;
        } else {
            if (tresPersonagens) {
                if (random.nextBoolean()){
                    return 3;
                } else {
                    return 1;
                }
            } else {
                if (doisPersonagens) {
                if (random.nextBoolean()){
                    return 2;
                } else {
                    return 1;
                }
            }
        }
    }
    return 1;
    }

    public static Local selecionaLocal(RepositorioLocais repositorioLocais) {
        List<Local> locais = repositorioLocais.getLocais();

        if (locais.isEmpty()){
            return null;
        }

        int qtdLocais = locais.size();
        int localSelecionado = random.nextInt(qtdLocais);

        return locais.get(localSelecionado);
    }

    public static void selecionarModo(int repeticoes,ArrayList<PersonagensGerais> arrayPersonagens, RepositorioLocais locais){
        for (int i = 0; i < repeticoes; i++){
            executarJogo(arrayPersonagens, locais);
        }
        return;
    }

    public static void limparTerminal() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
