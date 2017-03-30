package kz.epam.laboratory.stations;

import kz.epam.laboratory.ships.Ship;

import java.util.concurrent.BlockingQueue;

public class Dock extends Thread {

    private BlockingQueue<Ship> ships;

    public Dock(BlockingQueue<Ship> ships){
        this.ships = ships;
    }

    public void run(){

        while (true){
            if (ships != null){
                try {
                    Ship ship = ships.take();
                    System.out.println("Разгрузка корабля №"+ship.getNumber()+" началась. Примерное время разгрузки "
                            +ship.getTimeToUnloading()+" мс");
                    Thread.sleep(ship.getTimeToUnloading());
                    System.out.println("Корабль №"+ship.getNumber()+" пустым покинул порт");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
