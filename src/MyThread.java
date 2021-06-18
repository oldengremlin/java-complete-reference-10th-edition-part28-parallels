
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
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

    CyclicBarrier cbar;
    String name;

    MyThread(CyclicBarrier c, String s) {
        cbar = c;
        name = s;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
