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
    public void setTemaAcademico(int novoTema) {
        setArea(novoTema);
    }

    @Override
    public void exibeFicha() {
        System.out.print("\n===============\n");
        System.out.print("\nFicha do personagem\n");

        System.out.print("\nNome: "+getNome()+"\nArquétipo: "+getArquetipo()+"\nSociabilidade: "+getSociabilidade()+"\nTrabalho: "+getTrabalho()+"\nÁrea: "+getArea()+"\n");

        System.out.print("\n===============\n");
    }
}
