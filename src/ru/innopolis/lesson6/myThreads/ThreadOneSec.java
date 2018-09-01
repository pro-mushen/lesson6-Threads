package ru.innopolis.lesson6.myThreads;

import ru.innopolis.lesson6.SynchroTimer;

import java.util.List;

public class ThreadOneSec extends Thread {

    SynchroTimer synchroTimer;
    int countSec;
    List<ThreadTimer> list;

    public ThreadOneSec(SynchroTimer synchroTimer, int countSec, List<ThreadTimer> list) {
        this.synchroTimer = synchroTimer;
        this.countSec = countSec;
        this.list = list;
    }

    @Override
    public void run() {

        do{

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchroTimer.incrementSec();
            System.out.println(synchroTimer.getThisSec() + " сек");

        } while (countSec > synchroTimer.getThisSec());

        for (ThreadTimer threadTimer : list) {
            threadTimer.setStopIt(true);
        }
    }

}

