package gestionefile;


 //Classe che implementa l'interfaccia Runnable e rappresenta un'operazione di Vigenere su una matrice.
 //Contiene un intervallo di righe e colonne su cui operare.
 //in questo codice verrà usata per popolare la matrice.

public class Vigenere implements Runnable {

    private int ir;   // Indice di partenza per le righe
    private int fr;   // Indice di fine per le righe
    private int ic;   // Indice di partenza per le colonne
    private int fc;   // Indice di fine per le colonne
    private Matrice mt;  // Oggetto Matrice su cui operare

    
    public Vigenere(int ir, int fr, int ic, int fc, Matrice mt) {
        this.ir = ir;
        this.fr = fr;
        this.ic = ic;
        this.fc = fc;
        this.mt = mt;
    }

    @Override
    public void run() {
        popola();
    }

    
      //Popola la matrice con operazioni di Vigenere su un intervallo specificato.
      //Utilizza la somma dei valori ASCII per generare nuovi caratteri nella matrice.
     
    private void popola() {
        int c, r, car;
        for (r = ir; r < fr; r++) {
            for (c = ic; c < fc; c++) {
                // Calcola il nuovo valore ASCII sommando gli indici di riga e colonna
                car = r + c + 65;
                // Se il risultato supera "car", sottrai 26 per rimanere all'interno dell'alfabeto
                if (car > 90) {
                    car = car - 26;
                }
                // Imposta l'elemento nella matrice con il nuovo carattere
                this.mt.setElemento(r, c, car);
            }
        }
    }
}
