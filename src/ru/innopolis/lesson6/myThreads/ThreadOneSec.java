package ru.innopolis.lesson6.myThreads;

import ru.innopolis.lesson6.Main;
import ru.innopolis.lesson6.Monitor;

public class ThreadOneSec extends Thread {
    Monitor monitor;

    public ThreadOneSec(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {

        do{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(monitor) {
                monitor.incrementSec();
                System.out.println(monitor.getAllSec() + " сек");
                System.out.println(System.currentTimeMillis() - Main.startTime);
                monitor.notifyAll();
            }


        }while (true);

    }

}
