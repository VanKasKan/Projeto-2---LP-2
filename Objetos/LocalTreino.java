package Objetos;

import java.util.Random;

public class LocalTreino extends Local {

    private Random r = new Random();

    public LocalTreino(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagirSozinho(Personagem p) {
        String[] interacoes = {
            p.getNome() + " interaçao1.",
            p.getNome() + " interacao2.",
            p.getNome() + " interacao3.",
            p.getNome() + " interacao4.",
            p.getNome() + " interacao5."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(Personagem p1, Personagem p2) {
        String[] interacoes = {
            p1.getNome() + " interacao1 " + p2.getNome() + " interacao1.",
            p1.getNome() + " e " + p2.getNome() + " interacao2.",
            p1.getNome() + " interacao3 " + p2.getNome() + " interacao3",
            p1.getNome() + " e " + p2.getNome() + " interacao4.",
            p1.getNome() + " interacao5 " + p2.getNome() + ", interacao5."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(Personagem p1, Personagem p2, Personagem p3) {
        String[] interacoes = {
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " interacao1.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " interacao2.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " interacao3.",
            p1.getNome() + " interacao4 " + p2.getNome() + " e " + p3.getNome() + ", mas só sai ruído indecifrável.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " interacao5."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }
}
