package Objetos;
import java.io.Serial;
import java.io.Serializable;

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
}
