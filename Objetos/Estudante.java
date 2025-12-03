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

    public void alteraInteresse(){
        Menu token = new Menu();

        System.out.print("\n===============\n");
        System.out.print("\nQual o novo interesse?\n");
        System.out.print("\n[1] Artes Marciais\n[2] Astrologia\n[3] Honkai\n[4] História\n[5] Investimentos\n[0] Sair\n");
        System.out.print("\n===============\n");
        int novoInteresse = token.processaToken(0, 5);

        if(novoInteresse == 0){
            return;
        } else {
            setInteresses(novoInteresse);
            System.out.print("\nInteresse mudou para "+getInteresses()+"\n");
        }

    }

    @Override
    public void alteraTemaAcademico() {

    }
}
