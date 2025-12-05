package Objetos;

import java.util.Random;

public class LogicaJogo {

    private Random random = new Random();

    public void executarEvento(Local local, Personagem p1, Personagem p2, Personagem p3) {

        if (random.nextBoolean()) {
            local.interagirSozinho(p1);
        } else {
            if (p3 != null) {
            local.interagir3Personagens(p1, p2, p3);
            } else {
                local.interagir2Personagens(p1, p2);
            }
        }
    }
    public static void limparTerminal() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
