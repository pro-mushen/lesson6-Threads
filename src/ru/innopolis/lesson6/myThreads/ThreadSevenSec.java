package ru.innopolis.lesson6.myThreads;

import ru.innopolis.lesson6.Monitor;

public class ThreadSevenSec extends Thread {
    Monitor monitor;

    public ThreadSevenSec(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        do {
            synchronized(monitor) {

                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (monitor.getAllSec() % 7 == 0) {
                    System.out.println("Прошло ещё 7 секунд");
                }
            }

        }while (true);
    }
}
