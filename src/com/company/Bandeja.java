package com.company;

import java.util.ArrayList;

public class Bandeja {

    private ArrayList <Plate> lista = new ArrayList<>();

    public synchronized void ponerPlate(Plate plate) throws InterruptedException{
        synchronized (this) {
            lista.add(plate);
            notifyAll();
        }
    }

    public synchronized Plate cogerPlate() throws InterruptedException {
        Plate plate;
        synchronized (this) {
            while (lista.isEmpty()) {
                wait();
            }
            plate = lista.remove(0);
            notifyAll();
            return plate;
        }
    }

}
