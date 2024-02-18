package gestionefile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

//Classe che legge un file e mostra il contenuto in output.
//Estende la classe Thread

public class Lettore extends Thread{
    String nomeFile;

    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }

   //Legge il file senza tenere conto del tipo di file e lo mostra in output
   //Utilizza un BufferedReader per leggere il file.
    public void leggi(){
        int i; 
        try(BufferedReader fr = new BufferedReader(new FileReader(nomeFile))){ 

            //2) leggo carattere per carattere e lo stampo 
            while ((i=fr.read()) != -1)
                System.out.print((char) i);
            //Va a capo alla fine della lettura
            System.out.print("\n\r");
            //3) chiudo il file
        } catch (IOException ex) {
             // Gestione dell'eccezione in caso di errore di lettura
            System.err.println("Errore in lettura!");
        }
    }


    public void run(){
        //Metodo chiamato quando il thread viene avviato
        leggi();
    }
}
