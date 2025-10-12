package Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex1 {
    static void main(String[] args) throws IOException {
        String nume_fisier ="judete_in.txt";
        BufferedReader flux_in;
        String linie;
        List<String> ListaJud = new ArrayList<>();
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fisier)));
        while ( (linie = flux_in.readLine()) != null)
        {
            ListaJud.add(linie.trim());
        }
        flux_in.close();
        String [] Jud = new String[ListaJud.size()];
        for(int i = 0 ; i < ListaJud.size() ; i++)
        {
            Jud[i] = ListaJud.get(i);
        }
        Arrays.sort(Jud);
        System.out.println("Lista sortata este : ");
        for(int i = 0; i < Jud.length ; i ++)
        {
            System.out.println(" " +Jud[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti judetul pe care doriti sa il cautati : ");
        String nume_cautat = scanner.nextLine();
        int pozitie = Arrays.binarySearch(Jud, nume_cautat);
        System.out.println("Numele cautat este la pozitia : " + (pozitie + 1));
    }
}
