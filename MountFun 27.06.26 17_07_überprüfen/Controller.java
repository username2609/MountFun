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
    private int j;
    private int pause;
    private int punktestand;
    private int höchstpunktezahl;
    private ArrayList<Hindernis_model> hindernisscoreliste; 
    private boolean gestartet;
    public Controller(int höchstpunktezahlNeu){
        spielfigur = new Spielfigur_model();
        hindernisse = new Hindernis_model();
        view= new View(spielfigur,hindernisse);
        hindernisscoreliste = new ArrayList<>();
        view.fenster.addKeyListener(this);
        i = 0;
        j=0;
        höchstpunktezahl=höchstpunktezahlNeu;
        gestartet=false;
        Main();
    }

    public void Main(){
        view.spielfigurErstellen();
        int taktInterval = 10; // Taktgeschwindigkeit: 10ms
        ActionListener task = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(i == 100){
                        zufälligesHindernisHinzufügen();
                        i = 0;
                    }
                    if(j==60){
                        baumHinzufügen();
                        j=0;
                    }

                    for(Hindernis_view bäume: view.getBaumrand()){
                        bäume.baumNachObenRücken();
                    }

                    i++;
                    j++;

                    kollisionenPrüfen();
                    punktestandPrüfen();
                    hindernisseEntfernen();
                    baumEntfernen();
                    hindernisse.aktualisieren();
                    spielfigur.alleInformierenPublic();
                }
            };
        timer = new Timer(taktInterval, task);
        view.höchstpunktezahlSetzen(höchstpunktezahl);
                        
    }

    public void baumHinzufügen(){
        Random zufalla = new Random();
        Random zufallb = new Random();
        int x1 = zufalla.nextInt(130)+40;
        int x2 = zufallb.nextInt(130)+1840;
        Baum_view b1 = view.baumHinzufügen(x1,1000);
        Baum_view b2 = view.baumHinzufügen(x2,1000);      
        view.getBaumrand().add(b1);
        view.getBaumrand().add(b2);
        System.out.println("Baum erstellt");
    }

    public void zufälligesHindernisHinzufügen(){
        Random zufallz = new Random();
        int zahl = zufallz.nextInt(6) + 1;
        int verschiebungxl = 160;
        if(zahl == 4){
            zahl = 1;
        }
        else if(zahl == 5){
            zahl = 2;
        }

        if(zahl==1){
            Random zufall1 = new Random();
            int x = zufall1.nextInt(1700-verschiebungxl)+verschiebungxl;
            Slalomfahne_model slm1= new Slalomfahne_model(x);
            while(überlapptMit(slm1)){
                x = zufall1.nextInt(1700-verschiebungxl)+verschiebungxl;
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
            Random zufall2 = new Random();
            int x = zufall2.nextInt(1700-verschiebungxl)+verschiebungxl;
            Schneemann_model scm1 = new Schneemann_model(x);
            while(überlapptMit(scm1)){
                x=zufall2.nextInt(1700-verschiebungxl)+verschiebungxl;
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
            x = zufall3.nextInt(1630-verschiebungxl)+verschiebungxl;
            Hütte_model hm1 = new Hütte_model(x);
            while(überlapptMit(hm1)){
                x=zufall3.nextInt(1630-verschiebungxl)+verschiebungxl;
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
            Random zufall6 = new Random();
            int x = zufall6.nextInt(1760-verschiebungxl)+verschiebungxl;
            Münze_model mm1 = new Münze_model(x);
            while(überlapptMit(mm1)){
                x=zufall6.nextInt(1760-verschiebungxl)+verschiebungxl;
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

    /**
     * Wenn die Spielfigur mit einem Hindernis kollidiert ist das Spiel vorbei
     * und "Game over" wird angezeigt.
     * Wenn die Spielfigur mit einer Münze kollidiert(diese "einsammelt") wird 
     * der Punktestand um 10 erhöht und die Münze entfernt.
     */
    public void kollisionenPrüfen(){
        ArrayList<Hindernis_model> zuEnftferndendeHindernisse = new ArrayList<>();
        for(Hindernis_model h: hindernisse.getHindernisse()){
            if(spielfigur.kollidiertMit(h)){
                if(h.getName().equals("Münze")){
                    System.out.println(h.getName());
                    punktestand = punktestand+10;
                    view.punktestandSetzen(punktestand);
                    zuEnftferndendeHindernisse.add(h);
                    view.entferneMünzeView(h);
                }
                else{
                    stopTakt();
                    GameOver_view go = view.GameOverHinzufügen(812,521);
                    go.getKnopf().addActionListener(e -> {
                            neustart();
                        });

                }
            }
        }
        hindernisse.getHindernisse().removeAll(zuEnftferndendeHindernisse);
    }
    public void neustart(){
        if(punktestand>höchstpunktezahl){
            höchstpunktezahl=punktestand;
        }
        view.fensterEntfernen();
        Controller controller= new Controller(höchstpunktezahl);
        
        
    }
    public void punktestandPrüfen(){
        ArrayList<Hindernis_model> hindernisseToRemove = new ArrayList<>();
        for(Hindernis_model hs :hindernisscoreliste){
            if(hs.getY()<spielfigur.getY()){
                punktestand++;
                view.punktestandSetzen(punktestand);
                hindernisseToRemove.add(hs);
            }
        }
        hindernisscoreliste.removeAll(hindernisseToRemove);
    }
    
    public void hindernisseEntfernen(){
        ArrayList<Hindernis_model> zuEnftferndendeHindernisse = new ArrayList<>();
        for(Hindernis_model h: hindernisse.getHindernisse()){
            if(h.getY()+h.getHöhe()<100){
                zuEnftferndendeHindernisse.add(h);
                view.entferneHindernis(h);
            }
        }
        hindernisse.getHindernisse().removeAll(zuEnftferndendeHindernisse);
    }

    public void baumEntfernen(){
        for(Hindernis_view h: view.getBaumrand()){
            if(h.getY()<0){
                
                view.entferneBaum(h);
            }
        }
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

    /**
     * Startet den Takt, welcher durch die Klasse Timer Zeiten messen kann. Somit startet das Spiel
     */
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
            if(gestartet){
            spielfigur.nachRechtsBewegen();}
            else{
            spielfigur.nachRechtsBewegen();
            startTakt();
            gestartet=true;

        }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(gestartet){
            spielfigur.nachLinksBewegen();}
            else{
            spielfigur.nachLinksBewegen();
            startTakt();
            gestartet=true;

        }
        }

        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(gestartet){
            spielfigur.nachUntenBewegen();}
            else{
            spielfigur.nachUntenBewegen();
            startTakt();
            gestartet=true;

        }
        }

    }

    public void keyTyped(KeyEvent e){
    }

    

    public void updateSpielfigur(){
        spielfigur.alleInformierenPublic();
    }

    
}
