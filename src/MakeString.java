
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
public class MakeString implements Runnable {

    Exchanger<String> ex;
    String str;

    public MakeString(Exchanger<String> exgr) {
        ex = exgr;
        str = new String();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                str += (char) ch++;
            }
            try {
                str = ex.exchange(str);
            } catch (InterruptedException exc) {
                Logger.getLogger(MakeString.class.getName()).log(Level.SEVERE, null, exc);
            }
        }
    }

}
