
/**
 * Beschreiben Sie hier die Klasse Slalomfahne_model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Slalomfahne_model extends Hindernis_model
{
    public Slalomfahne_model(int xNeu){
        x=xNeu;
        y=1200;
        breite=33-verschiebung;
        höhe=59;
        name="Fahne";
    }
    @Override public int getY(){
        return y;
    }
    
    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }
}
