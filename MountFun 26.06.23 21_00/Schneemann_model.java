
public class Schneemann_model extends Hindernis_model
{
    public Schneemann_model(int xNeu){
        x=xNeu;
        höhe=202;
        breite=95-verschiebung;
        y=1200;
        name="Schneemann";
    }
    
    @Override public int getY(){
        return y;
    }
    
    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }
}
