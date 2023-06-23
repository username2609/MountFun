
public class Münze_model extends Hindernis_model
{
    public Münze_model(int xNeu){
        x=xNeu;
        y=1200;
        breite=28;
        höhe=32;
        name="Münze";
    }
    
    @Override public int getY(){
        return y;
    }
    
    public void anmelden(Hindernisbeobachter hb){
        hbeobachter.add(hb);
    }
}
