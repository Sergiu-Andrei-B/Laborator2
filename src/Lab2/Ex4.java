package Lab2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Ex4 {
    static class Persoana
    {
        private String Nume;
        private String CNP;

        public Persoana (String nume , String cnp)
        {
            this.Nume = nume;
            this.CNP = cnp;
        }

        public String getNume()
        {
            return Nume;
        }

        public String getCNP()
        {
            return  CNP;
        }
        public int GetVarsta()
        {
            int s = Integer.parseInt(CNP.substring(0, 1));
            int aa = Integer.parseInt(CNP.substring(1, 3));
            int ll = Integer.parseInt(CNP.substring(3, 5));
            int zz = Integer.parseInt(CNP.substring(5, 7));
            int anul;
            if (s == 1 || s == 2)
            {
                anul = 1900 + aa;
            }
            else if (s == 5 || s == 6)
            {
                anul = 2000 + aa;
            }
            else anul = 1800 + aa;
            LocalDate dataNasterii = LocalDate.of(anul, ll, zz);
            LocalDate azi = LocalDate.now();
            return Period.between(dataNasterii, azi).getYears();
        }

        public static boolean ValidareCNP(String CNP)
        {
            if(CNP.length() != 13)
            {
                return false;
            }
            for(int i = 0 ; i < CNP.length() ; i ++ )
            {
                if(!Character.isDigit(CNP.charAt(i)))
                {
                    return false;
                }
            }
            int primaCifra = CNP.charAt(0) - '0'; // -'0' converteste din Ascii in cifra charAt() returneaza un cod Ascii
            if(primaCifra != 1 && primaCifra != 2 && primaCifra != 5 && primaCifra != 6)
            {
                return false;
            }
            int[] coef = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
            int suma = 0;
            for (int i = 0; i < 12; i++) {
                suma += (CNP.charAt(i) - '0') * coef[i];
            }
            int rest = suma % 11;
            int cifraControl = (rest == 10) ? 1 : rest;

            return cifraControl == (CNP.charAt(12) - '0');
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane : ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Persoana[] persoane = new Persoana[n];
        for(int i = 0 ; i < n ; i ++)
        {
            System.out.println("Persoana " +(i+1) + ":");
            System.out.print("Nume : ");
            String Nume = scanner.nextLine();
            String CNP;
            while (true) {
                System.out.print("CNP: ");
                CNP = scanner.nextLine();
                if (Persoana.ValidareCNP(CNP)) break;
                else System.out.println("CNP invalid! Reîncercați.");
            }
            persoane[i] = new Persoana(Nume, CNP);
        }
        System.out.println("\n--- Lista persoanelor ---");
        for (Persoana p : persoane) {
            System.out.println(p.getNume() + ", " + p.getCNP() + ", " + p.GetVarsta() + " ani");
        }
        scanner.close();
    }
    }