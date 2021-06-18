
import java.util.concurrent.CyclicBarrier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olden
 */
public class BarDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, new BarAction());
        System.out.println("Запуск потоків");
        new Thread(new MyThread(cb, "A")).start();
        new Thread(new MyThread(cb, "B")).start();
        new Thread(new MyThread(cb, "C")).start();
        new Thread(new MyThread(cb, "D")).start();
        new Thread(new MyThread(cb, "E")).start();
        new Thread(new MyThread(cb, "F")).start();
    }
}
