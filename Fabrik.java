
/**
 * Die Klasse Fabrik ermöglicht den Einstieg in das Programm.
 * Die Klasse Fabrik enthält als globale Variable eine ArrayList in der alle Bestellungen gespeichert werden.
 * Eine neue Bestellung wird mit der Methode bestellungAufgeben() platziert, welche die Anzahl bestellter Standardtüren und Premiumtüren angibt.
 * Die Methode bestellungenAusgeben() durchläuft die Liste der Bestellungen und gibt jeweils die Information zu den einzelnen Bestellungen auf der Konsole aus.
 * ...
 * ...
 * @author Gruppe 10 (Christian Kaelin, Chiara Biasi, Cristobal Kuster, Javier Garcia, Stephanie Brunschwiler)  
 * @version (30.09.2024)
 */

// Importiere die Bibliotheksklasse ArrayList
import java.util.ArrayList;
import java.io.*;

public class Fabrik
{
    // Liste zur Speicherung aller Bestellungen
    private ArrayList<Bestellung> bestellungen;
    // Bestellungsnummer zur Identifizierung einer eingegangenen Bestellung
    private int bestellungsNr;

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik()
    {
        // Instanzvariable initialisieren
        // Leere ArrayList
        bestellungen = new ArrayList<Bestellung>();
        // Bestellnummer mit 0 initialisieren
        bestellungsNr = 0;
    }

    /**
     * Methode bestellungAufgeben() für das Aufgeben einer neue Bestellung mit Anzahl bestellter Standardtueren und Anzahl bestellter Premiumtueren.
     * Die maximale Bestellmenge wurde auf 460 Standardtueren und 20 Premiumtueren fixiert.
     * Die Bestellung wird nach dem Aufgeben als Ausgabe auf der Konsole zusammengefasst.
     */
    public void bestellungAufgeben(int anzahlStandardTueren, int anzahlPremiumTueren)
    {
        // Überprüfung, um sicherzustellen, dass standardTueren und premiumTueren positiv sind und <= 460 bzw. 20
    if (anzahlStandardTueren >= 0 && anzahlPremiumTueren >= 0 && anzahlStandardTueren <= 460 && anzahlPremiumTueren <= 20) {
        // bestellungsNr um 1 erhöhen für die naechste Bestellung
        bestellungsNr++;
        // Die Variablen sind positiv
        Bestellung bestellung = new Bestellung(bestellungsNr, anzahlStandardTueren, anzahlPremiumTueren);
        bestellungen.add(bestellung);
        // Bestelluebersicht ausgeben
        System.out.println(
        "Bestellung mit Bestellnummer " + bestellungsNr + " wurde aufgegeben und beinhaltet:" +
        "\n     Anzahl bestellte Standardtueren: " + anzahlStandardTueren +
        "\n     Anzahl bestellte Premiumtueren: " + anzahlPremiumTueren + "\n"
        );
    } else if(anzahlStandardTueren >= 460 | anzahlPremiumTueren >= 20){
        // Die maximale Bestellmenge wurde überschritten
        System.out.println("Die maximale Bestellmenge wurde überschritten. \n");
    } else {
        // Die Variablen sind nicht positiv
        System.out.println("Die Bestellmenge muss grösser 0 sein. \n");
    }
    
    }
    
    /**
     * Methode bestellungAusgeben(), um die Information aller Bestellungen auszugeben
     */
    public void bestellungAusgeben()
    {
        for(Bestellung bestellung : bestellungen) {
            System.out.println("Bestellnummer: " + bestellung.gibBestellungsNr() +
            ", Anzahl Standardtueren: " + bestellung.gibAnzahlStandardTueren() +
            ", Anzahl Premiumtueren: " + bestellung.gibAnzahlPremiumTueren() +
            ", Beschaffungszeit: " + bestellung.gibBeschaffungsZeit() +
            ", Bestellbestaetigung: " + bestellung.gibBestellBestaetigung()
            );
        }
    }
    
    /**
     * Methode main, um das Programm zu starten
     * Simulaton einer grafischen Benutzeroberfläche mit den Optionen:
     *      1 - Bestellung aufgeben (ruft die Methode bestellungAufgeben() auf)
     *      2 - Übersicht über alle Bestellungen ausgeben (ruft die Methode bestellungenAusgeben() auf)
     *      3 - Programm beenden
     */
    // Programm startet mit main-Methode (Programm beenden müssen wir später einbauen)
    public static void main(String[] args) {
        try {
            System.out.println("Start des Programms \n");
            Fabrik fabrik = new Fabrik();
            
            String zeile;
            int auswahl;
            boolean end = false;
            
            
            while (end == false){
                // Auswahl geben
                System.out.println("Geben Sie an, was sie tun möchten: \n" +
                "1 = Bestellung aufgeben \n" +
                "2 = Übersicht über alle Bestellungen ausgeben \n" +
                "3 = Programm beenden \n");
                
                //Eingabe des Nutzers holen
                BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
                zeile = infile.readLine();
                auswahl = Integer.parseInt(zeile.trim());
                
                //Eingabe des Nutzers verarbeiten
                if (auswahl == 1) {
                    System.out.println("Geben Sie die Anzahl der bestellten Standardtueren ein:");
                    int standardTueren = Integer.parseInt(infile.readLine().trim());
    
                    System.out.println("Geben Sie die Anzahl der bestellten Premiumtueren ein:");
                    int premiumTueren = Integer.parseInt(infile.readLine().trim());

                    fabrik.bestellungAufgeben(standardTueren, premiumTueren);
                } else if (auswahl == 2){
                    fabrik.bestellungAusgeben();
                    System.out.println("\n");
                } else if (auswahl == 3){
                    end = true;
                } else {
                    System.out.println("Ungültige Auswahl. Bitte wiederholen.");
                }
            } 
        }
        catch (Exception e) {
            System.out.println("Fehler: " + e);
            }
        }
    }
