import java.util.Timer;
import java.util.TimerTask;

public class Taktgeberunnötig {
    private Timer timer;
    private TimerTask task;
    private int tickgeschwindigkeit;
    private boolean läuft;

    public Taktgeberunnötig(int tickgeschwindigkeit) {
        this.tickgeschwindigkeit = tickgeschwindigkeit;
        this.läuft = false;
    }

    public void start() {
        if (!läuft) {
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    // Hier wird die Aktion ausgeführt, die bei jedem Takt ausgeführt werden soll
                }
            };
            timer.scheduleAtFixedRate(task, 0, tickgeschwindigkeit);
            läuft = true;
        }
    }

    public void stop() {
        if (läuft) {
            timer.cancel();
            läuft = false;
        }
    }

    public void settickgeschwindigkeit(int tickgeschwindigkeit) {
        this.tickgeschwindigkeit = tickgeschwindigkeit;
        if (läuft) {
            stop();
            start();
        }
    }
     
}