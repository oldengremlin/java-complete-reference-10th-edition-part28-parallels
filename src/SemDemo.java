
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
public class SemDemo {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        IncThread incThread = new IncThread(sem, "A"); //.start();
        DecThread decThread = new DecThread(sem, "B"); //.start();
    }
}
