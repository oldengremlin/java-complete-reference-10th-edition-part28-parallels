
import java.util.concurrent.Phaser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olden
 */
public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phsr = new Phaser();
        int curPhase;
        System.out.println("Запуск потоків");

        new Thread(new MyThread(phsr, "A")).start();
        new Thread(new MyThread(phsr, "B")).start();
        new Thread(new MyThread(phsr, "C")).start();
        new Thread(new MyThread(phsr, "D")).start();
        new Thread(new MyThread(phsr, "E")).start();
        new Thread(new MyThread(phsr, "F")).start();
        new Thread(new MyThread(phsr, "G")).start();
        new Thread(new MyThread(phsr, "H")).start();
        new Thread(new MyThread(phsr, "X")).start();
        new Thread(new MyThread(phsr, "Y")).start();
        new Thread(new MyThread(phsr, "Z")).start();

        //System.out.println("Фаза: перша");
        curPhase = phsr.getPhase();
        //phsr.arriveAndAwaitAdvance();
        phsr.awaitAdvance(phsr.getPhase());
        System.out.println("Фазу " + curPhase + " завершено");

        //System.out.println("Фаза: друга");
        curPhase = phsr.getPhase();
        //phsr.arriveAndAwaitAdvance();
        phsr.awaitAdvance(phsr.getPhase());
        System.out.println("Фазу " + curPhase + " завершено");

        //System.out.println("Фаза: третя");
        curPhase = phsr.getPhase();
        //phsr.arriveAndAwaitAdvance();
        phsr.awaitAdvance(phsr.getPhase());
        System.out.println("Фазу " + curPhase + " завершено");

        phsr.arriveAndDeregister();
        if (phsr.isTerminated()) {
            System.out.println("Синхронізатор фаз завершено");
        }
    }
}
