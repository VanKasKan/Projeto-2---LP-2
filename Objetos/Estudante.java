package Objetos;

public class Estudante extends Personagem {
    private Interesses interesses;

    public Estudante(Interesses interesses, String nome, Arquetipo arquetipo, int sociabilidade, Trabalho trabalho ){
        super(nome, arquetipo, sociabilidade, trabalho);
        this.interesses = interesses;
    }

    public Interesses getInteresses() {
        return interesses;
    }
}
