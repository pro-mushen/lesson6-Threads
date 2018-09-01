package ru.innopolis.lesson6;

import ru.innopolis.lesson6.myThreads.ThreadOneSec;
import ru.innopolis.lesson6.myThreads.ThreadTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static double startTime;
    public static void main(String[] args) throws InterruptedException {
        startTime = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        List<ThreadTimer> threads = new ArrayList<>();

        SynchroTimer synchroTimer = new SynchroTimer(lock);
        Thread threadOneSec = new ThreadOneSec(synchroTimer, 10, threads);
        threads.add(new ThreadTimer(synchroTimer, 5));
        threads.add(new ThreadTimer(synchroTimer, 7));
        threads.get(0).start();
        threads.get(1).start();
        threadOneSec.start();
        threadOneSec.join();
        threads.get(0).join();
        threads.get(1).join();

    }
}
