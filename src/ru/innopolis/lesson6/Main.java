package ru.innopolis.lesson6;

import ru.innopolis.lesson6.myThreads.ThreadFiveSec;
import ru.innopolis.lesson6.myThreads.ThreadOneSec;
import ru.innopolis.lesson6.myThreads.ThreadSevenSec;

public class Main {
    public static double startTime;
    public static void main(String[] args) throws InterruptedException {
        startTime = System.currentTimeMillis();
        Monitor monitor = new Monitor();

        ThreadOneSec threadOneSec = new ThreadOneSec(monitor);
        ThreadFiveSec threadFiveSec = new ThreadFiveSec(monitor);
        ThreadSevenSec threadSevenSec = new ThreadSevenSec(monitor);
        threadFiveSec.start();
        threadSevenSec.start();
        threadOneSec.start();
        threadOneSec.join();
        threadFiveSec.join();
        threadSevenSec.join();

    }
}
