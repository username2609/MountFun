
import java.awt.event.*;

public class Spieler implements KeyListener

{
    private Spielfigur Spielfigur;
    private Hindernis Hindernis;

    public void Spieler(){
        Spielfigur= new Spielfigur();
        Hindernis= new Hindernis(Spielfigur);
        Hindernis.addKeyListener(this);

    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e){
        System.out.println("key pressed" +"key char="+event.getKeyChar()+
            "key code= "+event.getKeyCode());
        if(e.getKeyCode()==KeyEvent.CHAR_UNDEFINED){
            int key=event.getKeyCode();

        }

        //Funktionstaste abfragen
        if(e.getKeyCode()==keyEvent.VK_RIGHT){
            Spielfigur.figurBewegenRechts();

        }

        if(e.getKeyCode()==keyEvent.VK_LEFT){
            Spielfigur.figurBewegenLinks();

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
