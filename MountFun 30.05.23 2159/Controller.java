
import java.awt.event.*;
import java.util.Random;

public class Controller implements KeyListener

{
    private Spielfigur_model spielfigur;
    private View view;
    private Taktgeber taktgeber;
    private Random zgenerator;
    public Controller(){
        spielfigur= new Spielfigur_model();
        view= new View();
        view.addKeyListener(this);
        taktgeber = new Taktgeber(1000); //1 Sekunde
        taktgeber.setTaktListener(() -> {
                // Hier werden die Aktualisierungen im Modell durchgeführt
                modell.aktualisieren();

                // Die aktualisierten Daten an die Ansicht übergeben
                ansicht.aktualisieren(modell.getDaten());
            });

    }

    public void Test(){
        start();
        while(true){
            System.out.println();
        }
    }

    public void HindernisErzeugen(){
        
    }
    
    public void start() {
        taktgeber.start();
    }

    public void stop() {
        taktgeber.stop();
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            spielfigur.nachRechtsBewegen();
        }
    }

    public void keyTyped(KeyEvent e){
    }

    public void verunfallt(){
    }

    public void updateSpielfigur(){

    }

    public void updateHindernis(){

    }

}
