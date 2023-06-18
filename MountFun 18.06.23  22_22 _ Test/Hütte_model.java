
/**
 * Beschreiben Sie hier die Klasse Hütte_model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Hütte_model extends Hindernis_model
{
    public Hütte_model(int xNeu){
        x=xNeu;
        y=1500;
        breite=290-verschiebung;
        höhe=305;
        name="Hütte";
    }
    @Override public int getY(){
        return y;
    }
    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }
}
