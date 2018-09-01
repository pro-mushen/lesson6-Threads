package ru.innopolis.lesson6.myThreads;

import ru.innopolis.lesson6.SynchroTimer;

public class ThreadTimer extends Thread {

    SynchroTimer synchroTimer;
    boolean stopIt = false;
    int step;

    public ThreadTimer(SynchroTimer synchroTimer, int step) {
        this.synchroTimer = synchroTimer;
        this.step = step;
    }

    @Override
    public void run() {
        do {
            synchroTimer.timeIsMultiple(step);
        } while (!stopIt);
    }

    public void setStopIt(boolean stopIt) {
        this.stopIt = stopIt;
    }
}
