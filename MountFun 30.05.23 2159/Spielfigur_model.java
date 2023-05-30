import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Spielfigur.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfigur_model
{
    protected int x, y,höhe,breite;
    private ArrayList<Figurenbeobachter> beobachter; 
    
    public Spielfigur_model(){
        x = 50;
        y = 50;
        höhe = 255;
        breite= 255;
        beobachter = new ArrayList<Figurenbeobachter>();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getBreite(){
        return breite;
    }
    public int getHöhe(){
        return höhe;
    }
    
    public void nachRechtsBewegen(){
        x=x+10;
    }
    public void nachLinksBewegen(){
        x=x-10;
    }
    
    public boolean kollidiertMit(Hindernis_model h){
         if (x < h.getX() + h.getBreite() &&
            x + breite > h.getX() &&
            y < h.getY() + h.getHöhe() &&
            y + höhe > h.getY()) {
            // Kollision erkannt
            return true;
        } else {
            // Keine Kollision
            return false;
    }
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
