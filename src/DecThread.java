
import java.util.concurrent.Semaphore;
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
public class DecThread implements Runnable {

    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Потік " + name + " очікує дозволу.");
            sem.acquire();
            System.out.println("Потік " + name + " отримав дозвіл.");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
            System.out.println("Потік " + name + " звільняє дозвіл.");
            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(DecThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
