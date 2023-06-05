import javax.swing.Timer;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Random;
import java.util.ArrayList;

public class Controller implements KeyListener

{
    private Spielfigur_model spielfigur;
    private View view; 
    private Hindernis_model hindernisse;
    private Timer timer;
    private int i;
    private int pause;
    private int highscore;
    private ArrayList<Hindernis_model> hindernisscoreliste; 
    public Controller(){
        spielfigur= new Spielfigur_model();
        hindernisse = new Hindernis_model();
        view= new View(spielfigur,hindernisse);
        hindernisscoreliste = new ArrayList<>();
        view.fenster.addKeyListener(this);
        Test();
        i=0;
    }

    public void Test(){
        view.spielfigurErstellen();
        int taktInterval = 4; // Taktgeschwindigkeit: 4ms
        ActionListener task = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(i==80){
                        zufälligesHindernisHinzufügen();
                        i=0;
                    }
                    i++;
                    for(Hindernis_model h: hindernisse.getHindernisse()){
                        //System.out.println(h.getX());
                        if(spielfigur.kollidiertMit(h)){
                            stopTakt();
                        }
                    }
                    highscorePrüfen();
                    hindernisse.aktualisieren();
                    spielfigur.alleInformierenPublic();

                }};
        timer = new Timer(taktInterval, task);
    }

    public void zufälligesHindernisHinzufügen(){
        Random random1 = new Random();
        int zahl = random1.nextInt(3) + 1;
        if(zahl==1){
            Random random2 =new Random();
            int x = random2.nextInt(1550);
            Slalomfahne_model slm1= new Slalomfahne_model(x);
            while(überlapptMit(slm1)){
                x=random2.nextInt(1550);
                slm1.xSetzen(x);
                slm1.ySetzen(800);
            }
            hindernisse.add(slm1);
            Slalomfahne_view slv1 = view.slalomfahneHinzufügen(x,100,slm1);
            view.Hinzufügen(slv1);
            hindernisscoreliste.add(slm1);
            System.out.println("Fahne erstellt");
        }
        else if(zahl==2){
            Random random3 =new Random();
            int x = random3.nextInt(1500);
            Schneemann_model scm1 = new Schneemann_model(x);
            while(überlapptMit(scm1)){
                x=random3.nextInt(1550);
                scm1.xSetzen(x);
                scm1.ySetzen(800);
            }
            hindernisse.add(scm1);
            Schneemann_view scv1 = view.schneemannHinzufügen(x,100,scm1);
            view.Hinzufügen(scv1);
            hindernisscoreliste.add(scm1);
            System.out.println("Schneemann erstellt");
        }
        else if(zahl==3){
            int x;
            Random random4 =new Random();
            x = random4.nextInt(1200);
            Hütte_model hm1 = new Hütte_model(x);
            while(überlapptMit(hm1)){
                x=random4.nextInt(1550);
                hm1.xSetzen(x);
                hm1.ySetzen(800);
            }
            hindernisse.add(hm1);
            Hütte_view hv1 = view.hütteHinzufügen(x,100,hm1);
            view.Hinzufügen(hv1);
            hindernisscoreliste.add(hm1);
            System.out.println("Hütte erstellt");

        }
    }

    public void highscorePrüfen(){
        ArrayList<Hindernis_model> hindernisseToRemove = new ArrayList<>();
        for(Hindernis_model hs :hindernisscoreliste){
            if(hs.getY()<spielfigur.getY()){
                highscore++;
                view.highscoreSetzen(highscore);
                hindernisseToRemove.add(hs);
            }
        }
        hindernisscoreliste.removeAll(hindernisseToRemove);
    }

    public boolean überlapptMit(Hindernis_model h) { 
        //vielleicht noch counter einbauen: falls zu viele
        //Hindernisse auf einmal(endloschleife), nur bei höherer geschw. ein Problem
        for (Hindernis_model j : hindernisse.getHindernisse()) {
            if (j.getX() < h.getX() + h.getBreite() &&
            j.getX() + j.getBreite() > h.getX() &&
            j.getY() < h.getY() + h.getHöhe() &&
            j.getY() + j.getHöhe() > h.getY()) {

                System.out.println(j.getName() + " überlappt mit " + h.getName());
                return true;
            }
        }

        return false;
    }

    public void startTakt() {
        timer.start();
    }

    public void stopTakt() {
        timer.stop();
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            spielfigur.nachRechtsBewegen();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            spielfigur.nachLinksBewegen();
        }

        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            spielfigur.nachUntenBewegen();
        }
    }

    public void keyTyped(KeyEvent e){
    }

    public void verunfallt(){
    }

    public void updateSpielfigur(){
        spielfigur.alleInformierenPublic();
    }

    public void updateHindernis(){

    }

    public static void main(String[] args) {

    }

}
