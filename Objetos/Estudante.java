package Objetos;

import Menu.Menu;
import java.io.Serial;

public class Estudante extends Personagem {
    @Serial
    private static final long serialVersionUID = 1L;
    private Interesses interesses;

    public Estudante(int interesses, String nome, int arquetipo){
        super(nome, arquetipo);
        setInteresses(interesses);
        setTrabalho(Trabalho.ESTUDANTE);

    }

    public void setInteresses(int interesses) {
        this.interesses = Interesses.values()[interesses-1];
    }

    public Interesses getInteresses() {
        return interesses;
    }

    @Override
    public void setTemaAcademico(int novoTema) {
        setInteresses(novoTema);
    }

    @Override
    public void exibeFicha() {
        System.out.print("\n===============\n");
        System.out.print("\nFicha do personagem\n");

        System.out.print("\nNome: "+getNome()+"\nArquétipo: "+getArquetipo()+"\nSociabilidade: "+getSociabilidade()+"\nTrabalho: "+getTrabalho()+"\nInteresse: "+getInteresses()+"\n");

        System.out.print("\n===============\n");
    }
}
