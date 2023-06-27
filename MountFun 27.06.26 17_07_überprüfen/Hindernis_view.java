import java.util.ArrayList;
import javax.swing.JLabel;

public class Hindernis_view
{
    protected int x, y,höhe,breite;

    public Hindernis_view(){

    }

    public void setY(int yNeu){
        y=yNeu;
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

    public JLabel getL1(){
        return null;
    }

    public void ortSetzen(int yNeu){
    }

    public Hindernis_model getModel(){
        return null;
    }
    
    public  void baumNachObenRücken(){
        
    }
}

