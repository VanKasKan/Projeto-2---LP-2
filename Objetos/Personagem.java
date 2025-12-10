package Objetos;

import java.io.Serial;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Scanner;
import Menu.Menu;

public abstract class Personagem implements Serializable, PersonagensGerais{
    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    private Arquetipo arquetipo;
    private int sociabilidade;
    private Trabalho trabalho;
    private HashMap<String, Integer> relacionamento;


    public Personagem(String nome, int arquetipo) {

        setNome(nome);
        setArquetipo(arquetipo);

    }

    public Arquetipo getArquetipo() {
        return arquetipo;
    }

    public String getNome() {
        return nome;
    }

    public int getSociabilidade() {
        return sociabilidade;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setArquetipo(int arquetipo) {

        this.arquetipo = Arquetipo.values()[arquetipo-1];
        setSociabilidade();

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSociabilidade() {

        if(getArquetipo() == Arquetipo.SORTUDO || getArquetipo() == Arquetipo.POTENCIA || getArquetipo() == Arquetipo.POPULAR || getArquetipo() == Arquetipo.CAPETA){

            sociabilidade = 100;

        } else if(getArquetipo() == Arquetipo.RELIGIOSO || getArquetipo() == Arquetipo.CONSELHO_ESTUDANTIL || getArquetipo() == Arquetipo.ATLETA){

            sociabilidade = 75;

        } else if(getArquetipo() == Arquetipo.OPERARIO || getArquetipo() == Arquetipo.OBSTINADO || getArquetipo() == Arquetipo.GENERICA || getArquetipo() == Arquetipo.ARTISTA){

            sociabilidade = 50;

        } else if(getArquetipo() == Arquetipo.PESO_MORTO || getArquetipo() == Arquetipo.HERDEIRO || getArquetipo() == Arquetipo.ESTUDIOSO || getArquetipo() == Arquetipo.AMNESICO){

            sociabilidade = 25;

        } else {

            sociabilidade = 1;

        }

    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public void manipularRelacionamento(int modificador, String nome) {
        if (this.relacionamento == null) {
            this.relacionamento = new HashMap<String, Integer>();
            manipularRelacionamento(modificador, nome);
        } else {
            if (this.relacionamento.containsKey(nome)) {
                int valorBase = this.relacionamento.get(nome);
                int valorModificado = valorBase + modificador;
                this.relacionamento.put(nome, valorModificado);
                return;
            } else {
                relacionamento.put((nome), this.relacionamento.getOrDefault(nome, 0) + modificador);
                return;
            }
        }
    }

    @Override
    public void exibeFicha(){

        System.out.print("\n===============\n");
        System.out.print("\nFicha do personagem\n");

        System.out.print("\nNome: "+getNome()+"\nArquétipo: "+getArquetipo()+"\nSociabilidade: "+getSociabilidade()+"\nTrabalho: "+getTrabalho()+"\n");

        System.out.print("\n===============\n");
    }

    public void alteraNome(Usuario usuarioAtual){
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.print("\n[0] Sair\nNovo nome: ");
            String novoNome = sc.next();
            sc.nextLine();

            if(novoNome.equals("0")){
                return;
            } else if (usuarioAtual.verificaExistenciaNome(novoNome)){

                System.out.print("\nEsse nome já existe! Escolha outro\n");

            } else {

                setNome(novoNome);
                System.out.print("\nNome atualizado para: "+getNome()+"\n");
                return;
            }
        }

    }

    public void alteraArquetipo(){
        Menu token = new Menu();

        System.out.print("\n===============\n");
        System.out.print("\nSelecione novo arquétipo\n");

        System.out.print("\n[ 1] Estudioso  [ 2] Amnesico             [ 3] Herdeiro    [ 4] Eremita      [ 5] Atleta");
        System.out.print("\n[ 6] Operário   [ 7] Conselho estudantil  [ 8] Artista     [ 9] Delinquente  [10] Soltario");
        System.out.print("\n[11] Religioso  [12] Potencia             [13] Peso morto  [14] Popular      [15] Capeta");
        System.out.print("\n[16] Obstinado  [17] Sortudo              [18] Vilão       [19] Generica      [0] Sair\n");
        System.out.print("\n===============\n");
        int novoArquetipo = token.processaToken(0, 19);

        if(novoArquetipo == 0){
            return;
        } else {
            setArquetipo(novoArquetipo);
        }
    }

    @Override
    public void alteraTemaAcademico(PersonagensGerais personagem) {
        Menu token = new Menu();

        if(trabalho == Trabalho.ESTUDANTE){

            System.out.print("\n===============\n");
            System.out.print("\nNovo interesse\n");
            System.out.print("\n[1] Artes Marciais\n[2] Astrologia\n[3] Honkai\n[4] História\n[5] Investimentos\n[0] Sair\n");
            System.out.print("\n===============\n");
            int novoInteresse = token.processaToken(0,5);
            if(novoInteresse == 0){
                return;
            }
            personagem.setTemaAcademico(novoInteresse);
        } else if(trabalho == Trabalho.PROFESSOR){

            System.out.print("\n===============\n");
            System.out.print("\nNova área\n");
            System.out.print("\n[1] Luta\n[2] Português\n[3] Língua estrangeira\n[4] Estratégia\n[5] História\n[0] Sair\n");
            System.out.print("\n===============\n");
            int novaArea = token.processaToken(0,5);
            if(novaArea == 0){
                return;
            }
            personagem.setTemaAcademico(novaArea);
        }
    }

    @Override
    public void setTemaAcademico(int novoTema) {

    }
}
