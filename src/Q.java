
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olden
 */
public class Q {

    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() throws InterruptedException {
        semCon.acquire();
        System.out.println("Отримано: " + n);
        semProd.release();
    }

    void put(int n) throws InterruptedException {
        semProd.acquire();
        this.n = n;
        System.out.println("Відправлено: " + n);
        semCon.release();
    }

}
