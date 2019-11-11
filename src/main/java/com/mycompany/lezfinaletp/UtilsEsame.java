/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lezfinaletp;

import javax.swing.JOptionPane;

/**
 * Metodo per far comparire finestra di input caricamento numeri interi
 *
 * @author tss
 */
public class UtilsEsame {

    static String setFirstCapitalize(String testo) {
        String ris = " ";
        String f = testo.substring(0, 1).toUpperCase();
        String o = testo.substring(1, testo.length()).toLowerCase();
        ris = f + o;
        return ris;
    }

    static int askInt(String testo) {
        //dichiaro la variabile di ritorno e la inizializzo  
        //contiene il numero come testo
        String strInt;
        int ris = 0;
        //contiene info su qualità strInt
        boolean schifezza = true;

        //elaboro ris 
        while (schifezza) {
            //chiedo all'utente una frase che contiene l'intero

            strInt = JOptionPane.showInputDialog(testo);

            //trasformo stringa in intero
            //può creare eroore allora la cirocnda con try catch
            try {
                ris = Integer.parseInt(strInt);
                schifezza = false;
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "inserisci un numero e non una frase");
            }
        }

        //ritorno il risultato ris
        return ris;

    }

    static int askInt(String testo, int min, int max) {
        //dichiaro la variabile di ritorno e la inizializzo  
        //contiene il numero come testo
        String strInt;
        int ris = 0;
        //contiene info su qualità strInt
        boolean schifezza = true;

        //elaboro ris 
        while (schifezza) {
            //chiedo all'utente una frase che contiene l'intero

            strInt = JOptionPane.showInputDialog(testo + " - minimo" + "e massimo" + max);

            //trasformo stringa in intero
            //può creare eroore allora la cirocnda con try catch
            try {
                ris = Integer.parseInt(strInt);

                if (ris >= min && ris <= max) {

                    schifezza = false;
                } else {
                    JOptionPane.showMessageDialog(null, "inserisci un numero e non una frase");
                }

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "inserisci un numero");
            }
        }

        //ritorno il risultato ris
        return ris;

    }

    static float askFloat(String testo, int min, int max) {
        //dichiaro la variabile di ritorno e la inizializzo  
        //contiene il numero come testo
        String strFloat;
        float ris = 0;
        //contiene info su qualità strInt
        boolean schifezza = true;

        //elaboro ris 
        while (schifezza) {
            //chiedo all'utente una frase che contiene l'intero

            strFloat = JOptionPane.showInputDialog(testo + " - minimo" + "e massimo" + max);

            //trasformo stringa in intero
            //può creare eroore allora la cirocnda con try catch
            try {
                ris = Float.parseFloat(strFloat);

                if (ris >= min && ris <= max) {

                    schifezza = false;
                } else {
                    JOptionPane.showMessageDialog(null, "inserisci un numero e non una frase");
                }

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "inserisci un numero");
            }
        }

        //ritorno il risultato ris
        return ris;
    }

    static float calcolaSconto(float prezzo, float sconto) {

        float ris = 0;
        float cento = 100;
        ris = prezzo - prezzo * sconto / 100;

        return ris;
    }

    static float scorporoPercentuale(float prezzoiva, float iva) {

        float ris = 0;
        float cento = 100;

        ris = prezzoiva / (1 + iva / 100);

        return ris;
    }

    static String aggiungiACapo(String testobase, String testoadd) {
        String ris = " ";
        ris = testobase + "\n" + testoadd;

        return ris;

    }

    static int[] caricaVoti(int numvoti) {
//dichiaro array per i voti grosso numvoti
        int[] arrvoti = new int[numvoti];
//ciclo tutti gli elementi dell'array caricadno i voti con askInt
        for (int i = 0; i < numvoti; i++) {
            arrvoti[i] = askInt("dimmiil voto (0..30)", 0, 30);
        }

        return arrvoti;
    }

    static String creaTabellone(int[] elencovoti) {

        String ris = " ";

        int tot = 0;
        for (int i = 0; i < elencovoti.length; i++) {
            ris += "#" + (i + 1) + "-" + elencovoti[i] + "\n";

            tot = tot + elencovoti[i];

        }
        int media = tot / elencovoti.length;
        ris += "voto medio" + media;

        return ris;
    }

    static String creaTabelloneHTML(int[] elencovoti) {

        String ris = "<table> ";

        float tot = 0;
        for (int i = 0; i < elencovoti.length; i++) {
            ris += "<tr><td>#" + (i + 1) + "</td><td>" + elencovoti[i] + "</td></tr>";

            tot = tot + elencovoti[i];

        }
        float media = tot / elencovoti.length;
        ris += "</table><br/><b>voto medio" + media;

        return ris;
    }
    
}
