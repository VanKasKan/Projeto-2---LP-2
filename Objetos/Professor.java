package Objetos;

public class Professor extends Personagem{
    private Area area;

    public Professor(Area area, String nome, Arquetipo arquetipo, int sociabilidade, Trabalho trabalho ){
        super(nome, arquetipo, sociabilidade, trabalho);
        this.area = area;
    }

    public Area getArea() {
        return area;
    }
    
}
