import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Hindernis_model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public  class Hindernis_model
{
    protected int x, y,höhe,breite,v, verschiebung;
    protected String name;
    protected ArrayList<Hindernis_model> hindernisliste; 
    protected ArrayList<Hindernisbeobachter> hbeobachter;
    public Hindernis_model(){
        hindernisliste= new ArrayList<>();
        hbeobachter = new ArrayList<Hindernisbeobachter>();
        v=1;
        x=-1;
        verschiebung=5;
    }

    public int getX(){
        return x;
    }

    public void add(Hindernis_model h){
        hindernisliste.add(h);
    }
    public void entfernen(Hindernis_model h){
        hindernisliste.remove(h);
    }

    public int getY(){
        return y;
    }
        
    public String getName(){
        return name;
    }

    public ArrayList<Hindernis_model> getHindernisse(){
        return hindernisliste;
    }

    public int getBreite(){
        return breite;
    }
    public void xSetzen(int xNeu){
        x=xNeu;
    }
    public void ySetzen(int yNeu){
        y=yNeu;
    }
    public int getHöhe(){
        return höhe;
    }

    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }

    public void geschwindigkeitSetzen(int g){
        v=g;
    }

    public void abmelden(Figurenbeobachter b){
        hbeobachter.remove(b);
    }

    public void aktualisieren(){
        for (Hindernis_model h : hindernisliste){
            h.nachObenRücken();
            for(Hindernisbeobachter hb: hbeobachter)
                hb.HindernisseGeaendert();
        }
    }

    

    public void nachObenRücken(){
        y=y-v;
    }
}
