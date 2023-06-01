import javax.swing.Timer;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Random;

public class Controller implements KeyListener

{
    private Spielfigur_model spielfigur;
    private View view;
    private Hindernis_model hindernisse;
    private Timer timer;
    public Controller(){
        spielfigur= new Spielfigur_model();
        hindernisse = new Hindernis_model();
        view= new View(spielfigur,hindernisse);
        view.addKeyListener(this);
        Test();
    }

    public void Test(){

        int taktInterval = 1000; // Taktgeschwindigkeit: 1 Sekunde (=1000ms)
        ActionListener task = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zufälligesHindernisHinzufügen();
                    hindernisse.aktualisieren();
                    spielfigur.alleInformierenPublic();
                    System.out.println("Code im Takt ausgeführt");
                }};
        timer = new Timer(taktInterval, task);
        startTakt();
    }

    public void zufälligesHindernisHinzufügen(){
        Random random = new Random();
        int zahl = random.nextInt(3) + 1;
        if(zahl==1){
            Slalomfahne_model sl1= new Slalomfahne_model();
            hindernisse.add(sl1);
            System.out.println("Fahne erstellt");
        }
        else if(zahl==2){
            Schneemann_model sc1 = new Schneemann_model();
            hindernisse.add(sc1);
            System.out.println("Schneemann erstellt");
        }
        else if(zahl==3){
            Hütte_model h1 = new Hütte_model();
            hindernisse.add(h1);
            System.out.println("Hütte erstellt");
        }
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
