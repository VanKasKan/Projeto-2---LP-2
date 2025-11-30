package Objetos;

import java.util.Random;

public class LocalBarulhento extends Local {

    private Random r = new Random();

    public LocalBarulhento(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagirSozinho(Personagem p) {
        String[] interacoes = {
            p.getNome() + " tenta pensar, não consegue ouvir a voz da própria cabeça.",
            p.getNome() + " grita 'ALGUÉM AÍ?' Mas ninguém ouviu.",
            p.getNome() + " tenta mandar um audio no celular, mas sai todo estourado.",
            p.getNome() + " fala sozinho achando que ninguém vai notar... E ninguém nota mesmo.",
            p.getNome() + " derruba uma barra de metal e falha em chamar a atenção das pessoas."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(Personagem p1, Personagem p2) {
        String[] interacoes = {
            p1.getNome() + " tenta conversar com " + p2.getNome() + ", mas eles só ficam gritando 'HÃ?' um para o outro.",
            p1.getNome() + " e " + p2.getNome() + " tentam fofocar, mas ninguém entende nada.",
            p1.getNome() + " discute com " + p2.getNome() + " mas nenhum dos dois sabe sobre o quê.",
            p1.getNome() + " e " + p2.getNome() + " pedem comida, mas recebem coisas completamente erradas.",
            p1.getNome() + " tenta contar um segredo para " + p2.getNome() + ", mas o bar inteiro responde 'QUÊ?' ao mesmo tempo."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(Personagem p1, Personagem p2, Personagem p3) {
        String[] interacoes = {
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " tentam se comunicar por mímica e falham miseravelmente.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " formam um círculo e ficam repetindo 'QUE?' em sincronia.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " pedem uma rodada de bebidas, mas cada um recebe algo completamente aleatório.",
            p1.getNome() + " tenta explicar algo para " + p2.getNome() + " e " + p3.getNome() + ", mas só sai ruído indecifrável.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " tiram uma foto, mas todo mundo atrás aparece gritando."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }
}
