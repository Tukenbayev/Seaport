package kz.epam.laboratory.stations;

import kz.epam.laboratory.ships.Ship;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SortStation extends Thread{

    private static BlockingQueue<Ship> ships = new ArrayBlockingQueue<Ship>(20);
    private ArrayList<DockStation> stations = new ArrayList<DockStation>();



    public static void addShip(Ship ship) {
        try {
            ships.put(ship);
        } catch (InterruptedException e) {

        }
    }

    public void run(){
        try {
            while (true){
                Ship ship = ships.take();
                for (DockStation station : stations)
                    if (station.getShipServiceType().equals(ship.getType())) {
                        switch (station.getShipServiceType()){
                            case OIL_TANK:
                                System.out.println("Корабль №"+ship.getNumber()+" направлен в док для разгрузки НЕФТИ");
                                break;
                            case CONTAINER_SHIP:
                                System.out.println("Корабль №"+ship.getNumber()+" направлен в док для разгрузки 40 ТОННЫХ КОНТЕЙНЕРОВ");
                                break;
                            case SMALL_CONTAINER_SHIP:
                                System.out.println("Корабль №"+ship.getNumber()+" направлен в док для разгрузки 20 ТОННЫХ КОНТЕЙНЕРОВ");
                                break;
                        }

                        station.addShip(ship);
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addStations(DockStation first, DockStation second, DockStation third){
        stations.add(first);
        stations.add(second);
        stations.add(third);
    }


}
