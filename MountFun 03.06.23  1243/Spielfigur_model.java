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
    
    private ArrayList<Figurenbeobachter> beobachter; 
    
    public Spielfigur_model(){
        x = 50;
        y = 50;
        höhe = 149;
        breite= 119;
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
        alleInformieren();
    }
    public void nachLinksBewegen(){
        x=x-10;
        alleInformieren();
    }
    public void nachUntenBewegen(){
        y=y+10;
        alleInformieren();
    }
    public boolean kollidiertMit(Hindernis_model h) {
    int spielfigurRechts = x + breite;
    int spielfigurUnten = y + höhe;
    int hindernisRechts = h.getX() + h.getBreite();
    int hindernisUnten = h.getY() + h.getHöhe();

    if (x < hindernisRechts && spielfigurRechts > h.getX() &&
        y < hindernisUnten && spielfigurUnten > h.getY()) {
        // Kollision erkannt
        System.out.println("Kollision!! mit"+h.getName());
        return true;
    } else {
        // Keine Kollision
        return false;
    }

}
    public boolean kollidiertMitalt(Hindernis_model h){
        System.out.println("x:"+x+"<"+"Breite Model+XPositionModel:"+h.getX() + h.getBreite());

         if (x < h.getX() + h.getBreite() &&
            x + breite > h.getX() &&
            y < h.getY() + h.getHöhe() &&
            y + höhe > h.getY()) {
            // Kollision erkannt
            System.out.println("Kollision!!");
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
    public void alleInformierenPublic(){
        y=y-1;
        alleInformieren();
        
    }
}
