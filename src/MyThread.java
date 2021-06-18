
import java.util.concurrent.CountDownLatch;

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

    CountDownLatch latch;
    String name;

    MyThread(CountDownLatch cdl, String s) {
        latch = cdl;
        name = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }

}
