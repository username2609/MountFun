import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Beschreiben Sie hier die Klasse Hindernis.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Hindernis extends JComponent implements Figurenbeobachter
{  private Spielfigur Spielfigur;
    /** Zufallsgenerator */
    Random zzgenerator;
    /** Taktzähler */
    int zähler;
    Zeichenfenster fenster;
    public Hindernis(Spielfigur s){
        Spielfigur= s;
        s.anmelden(this);        
        setFocusable(true);

        zähler = 8;
        zzgenerator = new Random();
        TaktdauerSetzen(400);

    }

    public void SpielfigurGeaendert(){
        repaint();
    }

    void TaktdauerSetzen (int dauer)
    {

        fenster.TaktdauerSetzen(dauer);
    }

    void TaktImpulsAusführen ()
    {  
        if(zähler<3)
        {
            zähler++;
        }
        else
        {
            HindernisErzeugen();
            zähler=0;
        }
    }

    void HindernisErzeugen()
    {
        int zufall = zzgenerator.nextInt(4);
        if (zufall == 0)
        {
            HindernisErzeugen(0,zzgenerator.nextInt(600),'O');
        }
        else
        {
            if (zufall == 1)
            {
                HindernisErzeugen(800,zzgenerator.nextInt(600),'W');
            }
            else
            {
                if (zufall == 2)
                {
                    HindernisErzeugen(zzgenerator.nextInt(800),0,'S');
                }
                else
                {
                    if (zufall == 3)
                    {
                        HindernisErzeugen(zzgenerator.nextInt(800),600,'N');
                    }
                    else
                    {
                        System.out.println("Fehler in Spiel, HindernisErzeugen()");
                    }
                }
            }
        }
    }

    void HindernisErzeugen(int x, int y, char richtung)
    {
        //Für eine neue Art von Hindernis musst du Obergrenze der Zufallszahl um eins erhöhen.
        //Füge dann einen neuen Fall für deine Klasse hinzu.
        int zufall = zzgenerator.nextInt(4);
        if (zufall == 0)
        {
            new Zickezacke(x, y, richtung);
        }
        else
        {
            if (zufall == 1)
            {
                new Quadrat(x, y, richtung);
            }
            else
            {
                if (zufall == 2)
                {
                    new Schlagbaum(x, y, richtung);
                }
                else
                {if (zufall == 4)
                    {
                        new Löschquadrat(x, y, richtung);
                    }
                    else
                    {
                        if (zufall == 3)
                        {
                            new Rotor(x, y, richtung);
                        }
                        else
                        {
                            System.out.println("Fehler in Spiel, HindernisErzeugen()");
                        }
                    }
                }
            }
        }
    }
}
