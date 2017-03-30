package kz.epam.laboratory.stations;

import kz.epam.laboratory.enums.ShipType;
import kz.epam.laboratory.ships.Ship;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DockStation {

    private BlockingQueue<Ship> ships = new ArrayBlockingQueue<Ship>(20);

    private Dock dock1 = new Dock(ships);
    private Dock dock2 = new Dock(ships);

    private ShipType shipServiceType;

    public DockStation(ShipType shipServiceType){
        this.shipServiceType = shipServiceType;
    }

    public void addShip(Ship ship){
        try {
            ships.put(ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ShipType getShipServiceType() {
        return shipServiceType;
    }

    public void start(){
        dock1.setDaemon(true);
        dock2.setDaemon(true);

        dock1.start();
        dock2.start();
    }
}
