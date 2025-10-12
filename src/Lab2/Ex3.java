package Lab2;

import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti sirul de caractere dorit de la tastatura : ");
        String sirul1 = scanner.nextLine();
        System.out.print("Introduceti sirul pe care doriti sa il concatenati cu sirul 1 : ");
        String sirul2 = scanner.nextLine();
        System.out.print("Introduceti pozitia la care vreti sa concatenati sirurile : ");
        int pozitie = scanner.nextInt();
        scanner.nextLine();
        StringBuilder sb = new StringBuilder(sirul1);
        //sb.append(" ").append(sirul2);
        sb.insert(pozitie,sirul2);
        System.out.println("Sirul dupa concatenare este : " + sb);
        System.out.print("Introduceti pozitia de la care doriti sa stergeti : ");
        int start = scanner.nextInt();
        System.out.print("Introduceti numarul de caractere pe care doriti sa le stergeti : ");
        int lungime = scanner.nextInt();
        sb.delete(start,(start+lungime));
        System.out.println("Sirul dupa stergere este : " + sb);
        scanner.close();
    }
}
