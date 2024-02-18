package gestionefile;

import java.io.IOException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

  //Classe principale che gestisce la lettura, elaborazione e scrittura di file.
  //Utilizza thread per eseguire operazioni conteporanemente.
 
public class GestioneFile {

    public static void main(String[] args) throws IOException {
        // Creazione di oggetti Matrice e Vigenere con parametri specifici
        Matrice mt = new Matrice("VIGENERE");
        Vigenere v = new Vigenere(0, 12, 0, 12, mt);
        Vigenere v1 = new Vigenere(12, 26, 0, 12, mt);
        Vigenere v2 = new Vigenere(0, 12, 0, 12, mt);
        Vigenere v3 = new Vigenere(12, 26, 12, 26, mt);

        // Creazione di thread per eseguire le operazioni di Vigenere in modo parallelo
        Thread t = new Thread(v);
        Thread t1 = new Thread(v1);
        Thread t2 = new Thread(v2);
        Thread t3 = new Thread(v3);

        // Avvio dei thread
        t.start();
        t1.start();
        t2.start();
        t3.start();

        try {
            // Attendere che tutti i thread completino l'esecuzione
            t.join();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            // Gestione dell'eccezione in caso di interruzione dei thread
        }

        // Lettura da file
        Lettore lettore = new Lettore("user.json");
        lettore.start();

        // Input da utente
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci Username:");
        String username = input.nextLine();
        String userNameC = mt.cifra(username);
        System.out.println("Inserisci Password:");
        String password = input.nextLine();
        String passwordC = mt.cifra(password);

        // Scrittura su file
        Scrittore scrittore = new Scrittore("output.csv", userNameC, passwordC);
        Scrittore copia = new Scrittore("copia.csv", userNameC, passwordC);
        Scrittore StreamCopia = new Scrittore("user.csv", userNameC, passwordC);
        Thread threadStream = new Thread(StreamCopia);
        threadStream.start();

        // Operazioni di scrittura su file
        final String dataFile = "user.csv";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(dataFile)));
        out.writeUTF(dataFile);
        Thread threadScrittore = new Thread(scrittore);
        Thread threadCopia = new Thread(copia);
        threadCopia.start();
        threadScrittore.start();
    }
}
