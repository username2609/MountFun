
public class Slalomfahne extends Hindernis
{
    private Spielfigur Spielfigur;
    
    public Slalomfahne(Spielfigur s, int x, int y)
    {
       Spielfigur = s;
       PositionSetzen(x, y);
    }

    /**
     * Lässt das Hindernis um 20 Einheiten nach oben bewegen 
     */
    public void Bewegen()
    {
        Bewegen(20);
        EntfernenWennAußerhalb();
    }
}
