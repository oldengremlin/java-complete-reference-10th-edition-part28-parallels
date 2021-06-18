
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olden
 */
public class MyThread implements Runnable {

    Phaser phsr;
    String name;

    MyThread(Phaser phsr, String s) {
        this.phsr = phsr;
        this.name = s;
        this.phsr.register();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Потік " + name + " починає " + phsr.getPhase() + " фазу ");
            phsr.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
