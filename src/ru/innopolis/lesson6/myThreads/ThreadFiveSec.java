package ru.innopolis.lesson6.myThreads;
import ru.innopolis.lesson6.Monitor;

public class ThreadFiveSec extends Thread {

    Monitor monitor;

    public ThreadFiveSec(Monitor monitor){
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

                if (monitor.getAllSec() % 5 == 0) {
                    System.out.println("Прошло ещё 5 секунд");
                }
            }

        }while (true);
    }

}
