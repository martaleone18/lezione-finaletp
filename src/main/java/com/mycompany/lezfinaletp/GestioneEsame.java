/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lezfinaletp;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class GestioneEsame {

    static String nomeEsame;
    static int listaVoti[];
    static String[] listaCognomi;
    static String[] listaNomi;
    static String msgAmmissioneok;
    static String msgAmmissioneno;
    static int sogliaAmmissione;
    static int maxvoto;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        // fase 1 richiamo preparaEsame
        preparaEsame();
        // fase 2 inizio sessione
        sessioneEsame();
        //fase 3 correzione ed assegnamento voti
        correzioneEsami();
        // fase 4 preparazione tabellone risultati
        visTabellone();

    }

    static void preparaEsame() {
        // inizzializza l'esame ovvero crea registro
        nomeEsame = JOptionPane.showInputDialog("inserisci nome esame");
        int quanti = UtilsEsame.askInt("inserisci max numero alunni", 1, 100);
        //creo registro
        listaCognomi = new String[quanti];
        listaNomi = new String[quanti];
        listaVoti = new int[quanti];
        maxvoto = UtilsEsame.askInt("valore massimo per promozione", 0, 100);
        sogliaAmmissione = UtilsEsame.askInt("valore minimo per promozione", 0, maxvoto);
        msgAmmissioneno = JOptionPane.showInputDialog(null, "messaggio sotto soglia (es. bocciato)", "bocciato");
        msgAmmissioneno = msgAmmissioneno.toUpperCase();
        msgAmmissioneok = JOptionPane.showInputDialog(null, "messaggio sopra soglia (es. ammesso)", "promosso");
        msgAmmissioneok = msgAmmissioneok.toUpperCase();

    }

    private static void sessioneEsame() {
        //caricare il registro coi partecipanti

        for (int i = 0; i < listaCognomi.length; i++) {
            listaCognomi[i] = JOptionPane.showInputDialog("dimmi il cognome " + (1 + i) + " di " + listaNomi.length);
            //dichiarare all'utente a quale alunno è arrivato 
            listaCognomi[i] = UtilsEsame.setFirstCapitalize(listaCognomi[i]);

            listaNomi[i] = JOptionPane.showInputDialog("dimmi il nome");
            //listaNomi[i] = Utils.setFirstCapitalize (JOptionPane.showInputDialog("dimmi il nome");
            listaNomi[i] = UtilsEsame.setFirstCapitalize(listaNomi[i]);

        }

    }

    private static void correzioneEsami() {
        //docente fornisce indietro gli esami di carta con il suo voto 
        //ogni esame ha sopra nome e cognome
        //caricamento voti
        for (int i = 0; i < listaNomi.length; i++) {
            String nome = listaNomi[i];
            String cog = listaCognomi[i];
            String msg = "inserisci il voto di " + nome + " " + cog;

            listaVoti[i] = UtilsEsame.askInt(msg, 0, maxvoto);
        }

    }

    private static void visTabellone() {

        String ris = "VOTAZIONI\n------\n " + nomeEsame.toUpperCase() + "\n---------\n";
        for (int i = 0; i < listaNomi.length; i++) {

            //cognome nome1 - voto = 70;
            //cognome nome2 - voto = 90;
            //cognome nome3 - voto = 85;
            ris = ris + listaCognomi[i] + "" + listaNomi[i];
            ris += "-voto =" + listaVoti[i] + "\n";
            if (listaVoti[i] >= sogliaAmmissione)//caso ok 
            // caso no
            {
                ris += "" + msgAmmissioneok + "\n";

            } else {
                ris += "" + msgAmmissioneno + "\n";

            }

        }
        //visualizzare output
        JOptionPane.showMessageDialog(null, ris);
    }

}
