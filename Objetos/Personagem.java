package Objetos;

import java.util.HashMap;

public abstract class Personagem {

    private String nome;
    private Arquetipo arquetipo;
    private int sociabilidade;
    private Trabalho trabalho;
    private HashMap<String, Integer> relacionamento;

    public Personagem(String nome, Arquetipo arquetipo, int sociabilidade, Trabalho trabalho) {
        setArquetipo(arquetipo);
        setNome(nome);
        setSociabilidade(sociabilidade);
        setTrabalho(trabalho);
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

    private void setArquetipo(Arquetipo arquetipo) {
        this.arquetipo = arquetipo;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setSociabilidade(int sociabilidade) {
        if (sociabilidade >= 0) {
            this.sociabilidade = sociabilidade;
        } else {
            this.sociabilidade = 0;
        }
    }

    private void setTrabalho(Trabalho trabalho) {
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
}
