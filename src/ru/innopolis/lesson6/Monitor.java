package ru.innopolis.lesson6;

public class Monitor {
    private int allSec;

    public int getAllSec() {
        return allSec;
    }

    public void setAllSec(int allSec) {
        this.allSec = allSec;
    }

    public int incrementSec(){
        return allSec++;
    }
}
