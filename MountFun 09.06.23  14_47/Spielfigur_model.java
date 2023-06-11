import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Spielfigur.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfigur_model
{
    protected int x,y,höhe,breite;
    private String orientierung;
    private ArrayList<Figurenbeobachter> beobachter; 
    
    public Spielfigur_model(){
        x = 700;
        y = 100;
        höhe = 171-5;
        breite= 98-5;
        beobachter = new ArrayList<Figurenbeobachter>();
        orientierung="Links";
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
    public String getOrientierung(){
        return orientierung;
    }
    public void nachRechtsBewegen(){
        x=x+10;
        orientierung="Rechts";
        alleInformieren();
    }
    public void nachLinksBewegen(){
        x=x-10;
        orientierung="Links";
        alleInformieren();
    }
    public void nachUntenBewegen(){
        y=y+10;
        alleInformieren();
    }
 
    public boolean kollidiertMit(Hindernis_model h){
        

         if (x < h.getX() + h.getBreite() &&
            x + breite > h.getX() &&
            y < h.getY() + h.getHöhe() &&
            y + höhe > h.getY()) {
            
            System.out.println("Kollision mit "+h.getName());
            return true;
        } else {
            
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
    public void alleInformierenPublic(){
        y=y-1;
        alleInformieren();
        
    }
}
