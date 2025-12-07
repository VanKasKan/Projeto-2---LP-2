package Objetos;

import java.util.Random;

public class LocalRomantico extends Local {

    private static final Random r = new Random();

    public LocalRomantico(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagirSozinho(PersonagensGerais p) {
        String[] interacoes = {
            p.getNome() + " se pergunta se vai ser amado de verdade um dia.",
            p.getNome() + " percebe que está muito sozinho para estar na ." + this.getNome() + " e vai embora,",
            p.getNome() + " olha para cima e sente falta de seu grande amor.",
            p.getNome() + " observa os outros casais na " + this.getNome() + " com nojo.",
            p.getNome() + " fecha os olhos e deixa a atmosfera romântica de " + this.getNome() + " envolver seus pensamentos."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir2Personagens(PersonagensGerais p1, PersonagensGerais p2) {
        String[] interacoes = {
            p1.getNome() + " e " + p2.getNome() + " trocam olhares tímidos enquanto o clima de " + this.getNome() + " fica mais intenso.",
            p1.getNome() + " tenta iniciar uma conversa com " + p2.getNome() + ", mas ambos ficam corados e desviam o olhar.",
            p1.getNome() + " e " + p2.getNome() + " caminham lado a lado, sentindo uma conexão silenciosa.",
            p1.getNome() + " nota o sorriso de " + p2.getNome() + " e sente o coração acelerar levemente.",
            p1.getNome() + " e " + p2.getNome() + " compartilham um momento leve e confortável, como se o tempo tivesse abrandado.",
            p1.getNome() + " passa por debaixo do visgo. " + p2.getNome() + " ri desconfortavelmente e pergunta 'como isso foi parar aí?' enquanto esconde um pacote de sementes atrás das costas",
            p1.getNome() + " decide que vai falar que queria ter beijado " + p2.getNome() + ". Mas só depois que eles voltarem pra casa.",
            p1.getNome() + " e " + p2.getNome() + " se aninham como passarinhos.",
            p1.getNome() + " esbarra de leve em " + p2.getNome() + " e ambos sorriem.",
            p1.getNome() + " olha nos olhos de " + p2.getNome() + " por alguns segundos, sem dizer nada.",
            p1.getNome() + " fica triste pensando em " + p2.getNome()
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
    }

    @Override
    public void interagir3Personagens(PersonagensGerais p1, PersonagensGerais p2, PersonagensGerais p3) {
        String[] interacoes = {
             p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " conversam calmamente, aproveitando a atmosfera suave de " + this.getNome() + ".",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " riem juntos, criando lembranças aconchegantes.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " sentem que o ambiente romântico parece aproximá-los mais.",
            p1.getNome() + " nota a cumplicidade entre " + p2.getNome() + " e " + p3.getNome() + ", resultando num sorriso discreto.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " trocam histórias sob o clima acolhedor de " + this.getNome() + ".",
            p1.getNome() + " pergunta se " + p2.getNome() + " e " + p3.getNome() + " estão ficando. Eles negam, mas " + p1.getNome() + " mostra um print em que ambos logaram Paddington 2 ao mesmo tempo no Letterboxd.",
            p1.getNome() + " faz uma piada que deixa " + p2.getNome() + " rindo descontrolavelmente. " + p3.getNome() + " faz cara feia pra ele.",
            p1.getNome() + ", " + p2.getNome() + " e " + p3.getNome() + " fazem um pacto de se casarem entre eles se não conseguirem arranjar ninguém em 30 anos.",
            p1.getNome() + " observa discretamente " + p2.getNome() + " e " + p3.getNome() + " caminhando de mãos dadas."
        };
        System.out.println(interacoes[r.nextInt(interacoes.length)]);
        LogicaJogo.limparTerminal();        
    }
}
