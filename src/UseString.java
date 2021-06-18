
import java.util.concurrent.Exchanger;
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
public class UseString implements Runnable {

    Exchanger<String> ex;
    String str;

    public UseString(Exchanger<String> exgr) {
        ex = exgr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                str = ex.exchange(new String());
            } catch (InterruptedException exc) {
                Logger.getLogger(UseString.class.getName()).log(Level.SEVERE, null, exc);
            }
            System.out.println("Отримано: " + str);
        }
    }

}
