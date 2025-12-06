package Objetos;

import java.util.Random;

public class LocalChatissimo extends Local {

    private static final Random r = new Random();


    public LocalChatissimo(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagirSozinho(PersonagensGerais p) {
        String[] interacoes = {
            p.getNome() + " olha as horas no relógio da" + this.getNome() + "e percebe que o tempo está correndo ao contrário.",
            p.getNome() + " bate a própria cabeça na parede repeditamente para sentir algo.",
            p.getNome() + " encara o abismo e torce para que ele o encare de volta.",
            p.getNome() + " resolve estudar para passar o tempo.",
            p.getNome() + " planeja uma rotina para mudar de vida.",
            p.getNome() + " suspira profundamente, como se esperasse que o ar respondesse.",
            p.getNome() + " procura algo interessante no chão da " + this.getNome() + ", mas não encontra nem poeira."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(PersonagensGerais p1, PersonagensGerais p2) {
        String[] interacoes = {
            p1.getNome() + " verifica se " + p2.getNome() + " ainda está vivo e percebe que sim. Entretanto, se está acordado já é outra história.",
            p1.getNome() + " e " + p2.getNome() + " fazem doomscrolling em seus celulares ao mesmo tempo.",
            p1.getNome() + " tenta chamar " + p2.getNome() + " para fazer alguma coisa, mas nada vem em mente.",
            p1.getNome() + " e " + p2.getNome() + " estão paralisados e não se movem a 40 minutos.",
            p1.getNome() + " busca animar as coisas com " + p2.getNome() + ", mas ficam entediados assim que entram na"+ this.getNome() + " .",
            p1.getNome() + " sugere que " + p2.getNome() + " toque no botão misterioso da " + this.getNome() + ". Ambos se arrependem imediatamente.",
            p1.getNome() + " e " + p2.getNome() + " ficam encarando o teto da " + this.getNome() + " como se esperassem uma revelação divina."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(PersonagensGerais p1, PersonagensGerais p2, PersonagensGerais p3) {
        String[] interacoes = {
             p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " entram na " + this.getNome() + " e imediatamente esquecem por que vieram.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " tentam conversar, mas cada um começa um assunto diferente ao mesmo tempo.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " ficam olhando para um ponto aleatório da " + this.getNome() + " sem motivo aparente.",
            p1.getNome() + " tenta falar algo com " + p2.getNome() + " e " + p3.getNome() + " na " + this.getNome() + ", mas só sai um ruído indecifrável.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " decidem se motivar mutuamente, falham e acabam deitados no chão.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " fazem um pacto silencioso de não fazer absolutamente nada.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " percebem que ninguém sabe como sair da " + this.getNome() + ".",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " abrem uma discussão filosófica que termina em risadas desconfortáveis.",
            p2.getNome() + " e " + p3.getNome() + " encontram um papel escrito 'Só trabalho sem diversão faz de " + p1.getNome() + " um bobão.\nSó trabalho sem diversão faz de " + p1.getNome() + "um bobão.\nSó trabalho sem diversão faz de " + p1.getNome() + " um bobão...' e resolvem sair do local"
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }
}
