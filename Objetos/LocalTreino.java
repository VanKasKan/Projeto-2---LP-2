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
            p.getNome() + " respira fundo e começa um aquecimento disciplinado.",
            p.getNome() + " treina socos repetidamente até sentir os braços queimarem.",
            p.getNome() + " faz flexões contando em voz baixa.",
            p.getNome() + " ajusta a postura e pratica golpes básicos com foco extremo.",
            p.getNome() + " corre ao redor de " + this.getNome() + " para melhorar o condicionamento."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(Personagem p1, Personagem p2) {
        String[] interacoes = {
            p1.getNome() + " e " + p2.getNome() + " fazem um breve aquecimento juntos.",
            p1.getNome() + " desafia " + p2.getNome() + " para um treino leve de sparring." + p2.getNome() + " exclama: 'vou nada, você só quer me bater de novo!'",
            p1.getNome() + " ajuda " + p2.getNome() + " a corrigir a postura de ataque.",
            p1.getNome() + " e " + p2.getNome() + " competem para ver quem faz mais flexões e ambos ficam a noite toda no " + this.getNome() + ".",
            p1.getNome() + " incentiva " + p2.getNome() + " a continuar mesmo cansado."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(Personagem p1, Personagem p2, Personagem p3) {
        String[] interacoes = {
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " fazem uma corrida para ver quem é o mais rápido.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " treinam combos sincronizados.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " revezam no saco de pancadas.",
            p1.getNome() + " incentiva " + p2.getNome() + " e " + p3.getNome() + " a aumentarem a intensidade.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " fazem alongamentos enquanto conversam sobre treinos passados.",
            p1.getNome() + " nocauteia " + p2.getNome() + " e olha para " + p3.getNome() + " que estava aos prantos, afirmando: 'se ele morrer, morreu.'",
            
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }
}
