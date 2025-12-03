package Objetos;


public interface PersonagensGerais {

    void exibeFicha();
    String getNome();
    Trabalho getTrabalho();
    void alteraNome(Usuario usuarioAtual);
    void alteraArquetipo();

    void setTemaAcademico(int novoTema);

    void alteraTemaAcademico(PersonagensGerais personagem);
}
