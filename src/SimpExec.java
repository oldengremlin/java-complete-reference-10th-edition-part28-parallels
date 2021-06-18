
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class SimpExec {

    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        CountDownLatch cdl5 = new CountDownLatch(5);
        CountDownLatch cdl6 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(3);

        System.out.println("Запуск потоків");
        es.execute(new MyThread(cdl1, "A"));
        es.execute(new MyThread(cdl2, "B"));
        es.execute(new MyThread(cdl3, "C"));
        es.execute(new MyThread(cdl4, "D"));
        es.execute(new MyThread(cdl5, "E"));
        es.execute(new MyThread(cdl6, "F"));
        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
            cdl5.await();
            cdl6.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpExec.class.getName()).log(Level.SEVERE, null, ex);
        }
        es.shutdown();
        System.out.println("Завершення потоків");
    }
}
