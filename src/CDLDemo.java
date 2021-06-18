
import java.util.concurrent.CountDownLatch;
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
public class CDLDemo {
        public static void main(String[] args) {
            CountDownLatch cdl = new CountDownLatch(5);
            System.out.println("Запуск потоку виконання");
            new Thread((Runnable) new MyThread(cdl)).start();
            try {
                cdl.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(CDLDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Завершення потоку виконання");
        }
}
