
import java.util.concurrent.Exchanger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olden
 */
public class ExgrDemo {

    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<String>();
        new Thread(new UseString(exgr)).start();
        new Thread(new MakeString(exgr)).start();
    }
}
