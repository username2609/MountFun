import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Hindernis_model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Hindernis_model
{
    protected int x, y,höhe,breite;
    protected ArrayList<Hindernis_model> hindernisse; 
    protected ArrayList<Hindernisbeobachter> hbeobachter;
    public Hindernis_model(){
        hindernisse= new ArrayList<>();
        hbeobachter = new ArrayList<Hindernisbeobachter>();
    }
    public int getX(){
        return x;
    }
    public void add(Hindernis_model h){
        hindernisse.add(h);
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
    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }
    
    public void abmelden(Figurenbeobachter b){
        hbeobachter.remove(b);
    }
    
    public void aktualisieren(){
        for (Hindernis_model h : hindernisse){
            h.nachObenRücken();
            for(Hindernisbeobachter hb: hbeobachter)
            hb.HindernisseGeaendert();
        }
    }
    public void nachObenRücken(){
        y=y-10;
    }
}
