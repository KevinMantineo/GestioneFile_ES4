# GestioneFile
Questo progetto Java gestisce operazioni di lettura, elaborazione e scrittura di file utilizzando la cifratura di Vigenere. Il programma utilizza thread per eseguire operazioni parallele.

# Struttura del progetto
GestioneFile.java: Classe principale che coordina le operazioni. Crea oggetti Matrice e Vigenere con parametri specifici, avvia thread per eseguire operazioni parallele di Vigenere, legge da un file, richiede input utente, e scrive su file.

Lettore.java: Classe che legge un file specificato e stampa il suo contenuto in output. Estende la classe Thread.

Matrice.java: Classe che rappresenta una matrice utilizzata per la cifratura di Vigenere. Contiene metodi per impostare e ottenere elementi della matrice, stamparla e cifrare/decifrare testo.

Scrittore.java: Classe che scrive su un file specificato i dati forniti come input. Implementa l'interfaccia Runnable.

Vigenere.java: Classe che implementa l'interfaccia Runnable e rappresenta un'operazione di Vigenere su una matrice. Contiene un intervallo di righe e colonne su cui operare. Utilizzata per popolare la matrice in modo concorrente.

# Come funziona 
Creazione di oggetti Matrice e Vigenere: Vengono creati oggetti Matrice e Vigenere con parametri specifici.

Operazioni parallele con thread: Vengono avviati quattro thread per eseguire operazioni parallele di Vigenere su diverse porzioni della matrice.

Lettura da file: Viene letto il contenuto di un file chiamato "user.json" utilizzando un thread.

Input da utente: L'utente inserisce un nome utente e una password, che vengono cifrati utilizzando la matrice Vigenere.

Scrittura su file: I dati cifrati vengono scritti su tre file diversi ("output.csv", "copia.csv", "user.csv") utilizzando thread separati per l'operazione di scrittura.



