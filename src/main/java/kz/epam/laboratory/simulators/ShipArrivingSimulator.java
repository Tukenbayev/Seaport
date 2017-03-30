package kz.epam.laboratory.simulators;

import kz.epam.laboratory.enums.ShipType;
import kz.epam.laboratory.ships.Ship;
import kz.epam.laboratory.stations.SortStation;

import java.util.Random;

public class ShipArrivingSimulator extends Thread {

    private Random timer = new Random();
    private Random shipType = new Random();
    private static int shipCounter = 0;

    public void run(){
        while (true){
            int sleepTime = timer.nextInt(1500);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}

            System.out.println("Корабль №"+ ++shipCounter+" прибыл в сортровочную станцию.");

            switch (shipType.nextInt(3)+1){
                case 1:
                    SortStation.addShip(new Ship(ShipType.OIL_TANK, shipCounter));
                    break;
                case 2:
                    SortStation.addShip(new Ship(ShipType.CONTAINER_SHIP,shipCounter));
                    break;
                case 3:
                    SortStation.addShip(new Ship(ShipType.SMALL_CONTAINER_SHIP,shipCounter));
                    break;
            }




        }
    }
}
