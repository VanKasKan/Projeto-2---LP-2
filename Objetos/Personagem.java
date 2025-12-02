package Objetos;

import java.io.Serial;
import java.util.HashMap;
import java.io.Serializable;

public abstract class Personagem implements Serializable{
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
        setSociabilidade();

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
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSociabilidade() {

        this.sociabilidade = 100;
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
}
