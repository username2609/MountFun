import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Spielfigur.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfigur
{
    private int x, y, seitenlaenge;
    private ArrayList<Figurenbeobachter> beobachter; 
    
    public Spielfigur(){
        x = 50;
        y = 50;
        seitenlaenge = 50;
        beobachter = new ArrayList<Figurenbeobachter>();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getSeitenlaenge(){
        return seitenlaenge;
    }
    
    public void anmelden(Figurenbeobachter b){
        beobachter.add(b);
    }
    
    public void abmelden(Figurenbeobachter b){
        beobachter.remove(b);
    }
    
    private void alleInformieren(){
        for (Figurenbeobachter b : beobachter){
            b.SpielfigurGeaendert();
        }
    }
}
