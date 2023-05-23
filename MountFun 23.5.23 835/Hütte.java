
public class Hütte extends Hindernis
{
    private Spielfigur Spielfigur;

    public Hütte(Spielfigur s, int x, int y)
    {   super(s);
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
