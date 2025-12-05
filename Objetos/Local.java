    package Objetos;

import java.io.Serializable;

public abstract class Local implements Serializable {

        private String nome;
        private String descricao;

        public Local(String nome, String descricao) {
            this.nome = nome;
            this.descricao = descricao;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public abstract void interagirSozinho(Personagem p);

        public abstract void interagir2Personagens(Personagem p1, Personagem p2);

        public abstract void interagir3Personagens(Personagem p1, Personagem p2, Personagem p3);
    }
