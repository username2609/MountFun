
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
