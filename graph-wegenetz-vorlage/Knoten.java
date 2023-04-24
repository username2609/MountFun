public class Knoten
{
    private Datenelement inhalt;

    public Knoten(Datenelement in){
        inhalt = in;
    }

    public Datenelement getInhalt(){
        return inhalt;
    }
    
    public void getDaten(){
        inhalt.ausgeben();
    }
}
