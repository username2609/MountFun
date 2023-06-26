import java.util.ArrayList;

public class Spielfigur_model
{
    private int x,y,höhe,breite;
    private String orientierung;
    private ArrayList<Figurenbeobachter> beobachter; 

    public Spielfigur_model(){
        höhe = 171-5;
        breite= 98-5;
        x = 900-breite/2;
        y = 500-höhe/2;
        beobachter = new ArrayList<Figurenbeobachter>();
        orientierung="Links";
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getBreite(){
        return breite;
    }

    public int getHöhe(){
        return höhe;
    }

    public String getOrientierung(){
        return orientierung;
    }

    public void nachRechtsBewegen(){
        x=x+10;
        orientierung="Rechts";
        alleInformieren();
    }

    public void nachLinksBewegen(){
        x=x-10;
        orientierung="Links";
        alleInformieren();
    }

    public void nachUntenBewegen(){
        y=y+15;
        alleInformieren();
    }

    public boolean kollidiertMit(Hindernis_model h){
        if(x<160 || x+breite>1760 || y<180||y+höhe>1080){
            return true;
        }

        if (x < h.getX() + h.getBreite() &&
        x + breite > h.getX() &&
        y < h.getY() + h.getHöhe() &&
        y + höhe > h.getY()) {
            System.out.println("Kollision mit "+h.getName());
            return true;
        } else {
            return false;
        }
    }

    public void anmelden(Figurenbeobachter b){
        beobachter.add(b);
    }

    public void abmelden(Figurenbeobachter b){
        beobachter.remove(b);
    }

    private void alleInformieren(){
        for (Figurenbeobachter b : beobachter){
            b.SpielfigurGeaendert();
        }
    }

    public void alleInformierenPublic(){
        y=y-1;
        alleInformieren();
    }
}
