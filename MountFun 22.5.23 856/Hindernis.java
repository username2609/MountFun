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
{   private Spielfigur Spielfigur;
    /** Zufallsgenerator */
    Random zzgenerator;
    /** Taktzähler */
    int zähler;
    Zeichenfenster fenster;
    /** x-Position der Figur. */
    private int x;
    /** y-Position der Figur. */
    private int y;
    /** Referenz auf das echte Figursymbol. */
    Zeichenfenster.FigurIntern symbol;

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
            new Slalomfahne(Spielfigur, x, y);
        }
        else
        {
            if (zufall == 1)
            {
                new Schneemann(Spielfigur, x, y);
            }
            else
            {
                if (zufall == 2)
                {
                    new Hütte(Spielfigur, x, y);
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

    public void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        symbol.PositionSetzen(x, y);
    }

    public void Bewegen(int k)
    {
        PositionSetzen(x,y+k);
    }

    /**
     * Entfernt das Hindernis, wenn es die Zeichenfläche verlässt
     */
    public void EntfernenWennAußerhalb()
    {
        if((XPositionGeben() < -100) || (XPositionGeben() > 900) || (YPositionGeben() < -100) || (YPositionGeben() > 700))
        {
            Entfernen();
        }
    }

    public int XPositionGeben()
    {
        return x;
    }

    public int YPositionGeben()
    {
        return y;
    }
}
