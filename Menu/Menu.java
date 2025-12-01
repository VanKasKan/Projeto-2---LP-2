package Menu;
import java.io.*;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private boolean modoEscuro;
    Scanner sc = new Scanner(System.in);


    public boolean isModoEscuro() {
        return modoEscuro;
    }

    public Menu(){
        setModoEscuro(false);
    }

    public int processaToken(int i, int j){

        while (true){
            try {
                int tk;
                System.out.print("Opção: ");
                tk = sc.nextInt();
                sc.nextLine();

                if(tk < i || tk > j){

                    System.out.print("\nOpção inválida\n");

                } else {

                    return tk;

                }

            } catch(InputMismatchException e) {

                System.out.print("\nOpção inválida\n");
                sc.nextLine();

            }
        }
    }

    public void setModoEscuro(boolean modoEscuro) {
        this.modoEscuro = modoEscuro;
    }

    public ArrayList<Usuario> carregaLogins() throws IOException, ClassNotFoundException{

        ArrayList<Usuario> usuarios;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dados/Logins.bin"));

        usuarios = (ArrayList<Usuario>) ois.readObject();

        return usuarios;
    }

    public ObjectOutputStream criaPastaLogins() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dados/Logins.bin"));
        return oos;

    }

}
