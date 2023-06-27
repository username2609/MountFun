
public class Hütte_model extends Hindernis_model
{
    public Hütte_model(int xNeu){
        x=xNeu;
        y=1200;
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
