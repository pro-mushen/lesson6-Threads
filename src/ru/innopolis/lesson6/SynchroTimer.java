package ru.innopolis.lesson6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SynchroTimer {
    private int ThisSec;
    private Lock locker;
    private Condition condition;

    public SynchroTimer(Lock locker) {
        this.locker = locker;
        this.condition = locker.newCondition();
    }

    public Condition getCondition() {
        return condition;
    }

    public int getThisSec() {
        return ThisSec;
    }


    public void timeIsMultiple(int time) {
        locker.lock();
        try {
            condition.await();
            if (ThisSec % time == 0) {
                System.out.println("Прошло уже " + time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public int incrementSec() {
        locker.lock();
        try {
            ThisSec++;
            condition.signalAll();
            return ThisSec;
        } finally {
            locker.unlock();
        }
    }
}
