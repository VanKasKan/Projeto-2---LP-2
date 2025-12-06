package Objetos;
import java.util.ArrayList;

public interface ILocal{
    void adicionar(Local local);
    Local obter(int indice);
    void remover(int indice);
    int tamanho();
    ArrayList<Local> obterTodos();
    
    void substituir(int indice, Local novoLocal);
}
