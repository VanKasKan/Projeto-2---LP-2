package Objetos;

import java.util.Random;

public class LocalQuieto extends Local {

    private static final Random r = new Random();

    public LocalQuieto(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagirSozinho(PersonagensGerais p) {
        String[] interacoes = {
            p.getNome() + " consegue ouvir o próprio coração batendo.",
            p.getNome() + " nota que " + this.getNome() + " é um bom local para sangrar até morrer pacificamente.",
            p.getNome() + " escutou o próprio pensamento e se incomodou com a barulheira.",
            p.getNome() + " aprecia a calmaria, mas a calmaria não aprecia ele de volta.",
            p.getNome() + " ouve um zumbido distante e se pergunta se está ficando louco.",
            p.getNome() + " relaxa confortavelmente.",
            p.getNome() + " começa a se lembrar de coisas que deveriam permanecer esquecidas."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(PersonagensGerais p1, PersonagensGerais p2) {
        String[] interacoes = {
            p1.getNome() + " faz um gesto para " + p2.getNome() + " ficar quieto. " + p2.getNome() + " nem estava falando.",
            p1.getNome() + " e " + p2.getNome() + " andam lado a lado em " + this.getNome() + " sem emitir um único som.",
            p1.getNome() + " pergunta algo para " + p2.getNome() + ", mas " + p2.getNome() + " só responde com um leve aceno.",
            p1.getNome() + " e " + p2.getNome() + " parecem sincronizar a respiração sem querer.",
            p1.getNome() + " caminha lentamente para não perturbar o silêncio de " + this.getNome() + ", e " + p2.getNome() + " o imita.",
            p1.getNome() + " e " + p2.getNome() + " refletem se deveriam se tornar jogadores profissionais de Xadrez. Eles jogam uma partida e desistem da ideia após " + p1.getNome() + " incitar um assassinato político contra o próprio Rei.",
            p1.getNome() + " percebe que " + p2.getNome() + " está mais queito que o normal e isso o preocupa."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(PersonagensGerais p1, PersonagensGerais p2, PersonagensGerais p3) {
        String[] interacoes = {
             p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " tentam conversar em sussurros, mas desistem.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " ficam quietos juntos. Estranhamente, faz sentido.",
            p1.getNome() + " observa " + p2.getNome() + " que observa " + p3.getNome() + ", e ninguém entende nada.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " caminham em fila indiana para não fazer barulho.",
            p1.getNome() + " tenta dizer algo para " + p2.getNome() + " e " + p3.getNome() + ", mas perde a vontade no meio da frase.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " tentam ouvir algum som, mas não há som algum.",
            p1.getNome() + " respira fundo, e tanto " + p2.getNome() + " quanto " + p3.getNome() + " o encaram como se fosse um trovão.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " apreciam o silêncio desconfortável em " + this.getNome() + ".",
            p1.getNome() + " tenta brincar para quebrar o silêncio, mas " + p2.getNome() + " e " + p3.getNome() + " o ignoram calmamente.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " compartilham um momento tão quieto que chega a ser estranho.",
            p1.getNome() + " e " + p2.getNome() + " juram ter escutado a voz de " + p3.getNome() + " na " + this.getNome() + "... Mas não tem ninguém ali."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }
}
