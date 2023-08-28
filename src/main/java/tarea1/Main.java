package tarea1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor ingresa la ruta completa de la carpeta: ");
        String path = sc.nextLine();

        System.out.print("Por favor ingresa la palabra que desea buscar: ");
        String word = sc.nextLine();

        sc.close();
        Folder folder = new Folder(path, word);
        folder.showTotalCount();
    }
}
