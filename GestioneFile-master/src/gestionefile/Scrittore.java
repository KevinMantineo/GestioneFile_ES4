package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Classe che scrive su un file i dati forniti come input.
//Implementa l'interfaccia Runnable 

public class Scrittore implements Runnable {

    String nomeFile;
    String username;
    String password;

    public Scrittore(String nomeFile, String username, String password) {
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        // Metodo chiamato quando il thread viene avviato
        scrivi();
    }

    //Scrive i dati forniti su un file specificato. 
    //Utilizza un BufferedWriter per scrivere in modo efficiente.
    
    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            // Scrive i dati forniti su un file
            br.write("<" + username + ">");
            br.write("\n\r");
            br.write("<" + password + ">");
            br.write("\n\r");
            br.flush();
        } catch (IOException ex) {
            // Gestione dell'eccezione in caso di errore di scrittura
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
