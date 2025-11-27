package Objetos;

import java.util.Random;

public class LogicaJogo {

    private Random random = new Random();

    public void executarEvento(Local local, Personagem p1, Personagem p2) {

        if (random.nextBoolean()) {
            local.interagirSozinho(p1);
        } else {
            local.interagirAcompanhado(p1, p2);
        }
    }
}
