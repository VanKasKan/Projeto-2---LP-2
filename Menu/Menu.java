package Menu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public ArrayList<Usuario> carregaLogins() throws IOException, ClassNotFoundException{

        System.out.print("\nCarregando logins...\n");

        ArrayList<Usuario> usuarios;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Logins.bin"));

        usuarios = (ArrayList<Usuario>) ois.readObject();

        return usuarios;
    }

    public ObjectOutputStream criaPastaLogins() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dados/Logins.bin"));
        return oos;

    }

}
