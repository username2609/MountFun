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
    
    public Hindernis_model(){
        hindernisse= new ArrayList<>();
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
}
