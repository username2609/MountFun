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
        i=0;
        Main();
    }

    public void Main(){
        view.spielfigurErstellen();
        int taktInterval = 10; // Taktgeschwindigkeit: 10ms
        ActionListener task = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Hindernis_model> zuEnftferndendeHindernisse = new ArrayList<>();
                    if(i==100){
                        zufälligesHindernisHinzufügen();
                        i=0;
                    }
                    i++;

                    for(Hindernis_model h: hindernisse.getHindernisse()){
                        //System.out.println(h.getX());
                        if(spielfigur.kollidiertMit(h)){
                            if(h.getName().equals("Münze")){
                                System.out.println(h.getName());
                                highscore=highscore+10;
                                view.highscoreSetzen(highscore);
                                zuEnftferndendeHindernisse.add(h);
                                view.entferneMünzeView(h);

                            }
                            else{
                                stopTakt();
                            }
                        }
                    }
                    hindernisse.getHindernisse().removeAll(zuEnftferndendeHindernisse);
                    highscorePrüfen();
                    hindernisseEntfernen();
                    hindernisse.aktualisieren();
                    spielfigur.alleInformierenPublic();

                }};
        timer = new Timer(taktInterval, task);
    }

    public void zufälligesHindernisHinzufügen(){
        Random zufallz = new Random();
        int zahl = zufallz.nextInt(6) + 1;
        int verschiebungxl = 160;
        if(zahl==4){
            zahl=1;
        }
        else if(zahl==5){
            zahl=2;
        }

        if(zahl==1){
            Random zufall1 =new Random();
            int x = zufall1.nextInt(1760-verschiebungxl)+verschiebungxl;
            Slalomfahne_model slm1= new Slalomfahne_model(x);
            while(überlapptMit(slm1)){
                x=zufall1.nextInt(1760-verschiebungxl)+verschiebungxl;
                slm1.xSetzen(x);
                slm1.ySetzen(1200);
            }
            hindernisse.add(slm1);
            Slalomfahne_view slv1 = view.slalomfahneHinzufügen(x,100,slm1);
            view.Hinzufügen(slv1);
            hindernisscoreliste.add(slm1);
            System.out.println("Fahne erstellt");
        }
        else if(zahl==2){
            Random zufall2 =new Random();
            int x = zufall2.nextInt(1760-verschiebungxl)+verschiebungxl;
            Schneemann_model scm1 = new Schneemann_model(x);
            while(überlapptMit(scm1)){
                x=zufall2.nextInt(1760-verschiebungxl)+verschiebungxl;
                scm1.xSetzen(x);
                scm1.ySetzen(1200);
            }
            hindernisse.add(scm1);
            Schneemann_view scv1 = view.schneemannHinzufügen(x,100,scm1);
            view.Hinzufügen(scv1);
            hindernisscoreliste.add(scm1);
            System.out.println("Schneemann erstellt");
        }
        else if(zahl==3){
            int x;
            Random zufall3 =new Random();
            x = zufall3.nextInt(1760-verschiebungxl)+verschiebungxl;
            Hütte_model hm1 = new Hütte_model(x);
            while(überlapptMit(hm1)){
                x=zufall3.nextInt(1760-verschiebungxl)+verschiebungxl;
                hm1.xSetzen(x);
                hm1.ySetzen(1200);
            }
            hindernisse.add(hm1);
            Hütte_view hv1 = view.hütteHinzufügen(x,100,hm1);
            view.Hinzufügen(hv1);
            hindernisscoreliste.add(hm1);
            System.out.println("Hütte erstellt");

        }
        else if(zahl==6){
            Random zufall6 =new Random();
            int x = zufall6.nextInt(1760-verschiebungxl)+verschiebungxl;
            Münze_model mm1= new Münze_model(x);
            while(überlapptMit(mm1)){
                x=zufall6.nextInt(1550);
                mm1.xSetzen(x);
                mm1.ySetzen(800);
            }
            hindernisse.add(mm1);
            Münze_view mv1 = view.münzeHinzufügen(x,100,mm1);
            view.Hinzufügen(mv1);
            hindernisscoreliste.add(mm1);
            System.out.println("Münze erstellt");
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

    public void hindernisseEntfernen(){
        ArrayList<Hindernis_model> zuEnftferndendeHindernisse = new ArrayList<>();
        for(Hindernis_model h: hindernisse.getHindernisse()){
            if(h.getY()<200){
                zuEnftferndendeHindernisse.add(h);
                view.entferneHindernis(h);
            }
        }
        hindernisse.getHindernisse().removeAll(zuEnftferndendeHindernisse);
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


}
