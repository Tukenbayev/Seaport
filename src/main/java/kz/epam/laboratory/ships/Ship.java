package kz.epam.laboratory.ships;

import kz.epam.laboratory.enums.ShipType;

import java.util.Random;

public class Ship {
    private static Random timer = new Random();
    private ShipType type;
    private int timeToUnloading;
    private int number;

    public Ship(ShipType type, int number){
        this.type = type;
        this.number = number;

        timeToUnloading = timer.nextInt(1200);

        switch (type){
            case OIL_TANK:
                timeToUnloading += 2000;
                break;
            case CONTAINER_SHIP:
                timeToUnloading +=1000;
                break;
        }

    }

    public ShipType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public int getTimeToUnloading() {
        return timeToUnloading;
    }

    public void setTimeToUnloading(int timeToUnloading) {
        this.timeToUnloading = timeToUnloading;
    }
}
