package Objetos;

public class Professor extends Personagem{
    private Area area;

    public Professor(int area, String nome, int arquetipo){
        super(nome, arquetipo);
        setArea(area);
        super.setTrabalho(Trabalho.PROFESSOR);
    }

    public void setArea(int area) {
        this.area = Area.values()[area-1];
    }

    public Area getArea() {
        return area;
    }

    @Override
    public void alteraTemaAcademico() {

    }
}
