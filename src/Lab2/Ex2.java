package Lab2;

import java.io.*;

class Vers
{
    private String text;
    public Vers(String text)
    {
        this.text = text;
    }

    public int NumaraCuvintele()
    {
        if(text.trim().isEmpty())
        {
            return 0;
        }
        String[] cuvinte = text.trim().split(" +");
        return cuvinte.length;
    }

    public int NumaraVocalele()
    {
        int contor = 0;
        for( int i = 0 ; i < text.length() ; i++)
        {
           char voc = text.charAt(i);
           if( voc == 'a'|| voc == 'e'|| voc == 'i' ||voc == 'o' ||voc == 'u')
           {
               contor ++ ;
           }
        }
        return contor;
    }

    public boolean Final(String grupare)
    {
        return text.endsWith(grupare);
    }

    public String Majuscule()
    {
        double nrAleator = Math.random(); // math.random() genereaza aleator un nr in intervalul [0.0 ; 1.0]
        if( nrAleator < 0.1)
        {
            return text.toUpperCase();
        }
        return text;
    }
}

public class Ex2 {
    static void main(String[] args) throws IOException {
        String nume_fisier = "cantec_in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fisier)));
        File cantec_out = new File("C:\\Users\\Bobo\\Desktop\\PJ\\Lab2\\Laborator2\\cantec_out.txt");
        if (cantec_out.createNewFile()) {
            System.out.println("Fișierul a fost creat cu succes: " + cantec_out.getName());
        } else {
            System.out.println("Fișierul există deja: " + cantec_out.getName());
        }
        BufferedWriter flux_out;
        flux_out = new BufferedWriter(new FileWriter("cantec_out.txt"));
        String linie;
        while ((linie = flux_in.readLine()) != null)
        {
            Vers v = new Vers(linie);
            int nrCuvinte = v.NumaraCuvintele();
            int nrVocale = v.NumaraVocalele();
            String textFinal = v.Majuscule();
            if(v.Final("eu"))
            {
                textFinal += " *";
            }
            flux_out.write(textFinal + " | Cuvinte : " + nrCuvinte + " | Vocale : " + nrVocale);
            flux_out.newLine();
        }
        flux_in.close();
        flux_out.close();
    }
}
