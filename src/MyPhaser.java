/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.Phaser;

/**
 *
 * @author olden
 */
public class MyPhaser extends Phaser {

    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount;
    }

    @Override
    protected boolean onAdvance(int p, int regParties) {
        System.out.println("Фазу " + p + " завершено");
        return (p == numPhases || regParties == 0);
    }
}
