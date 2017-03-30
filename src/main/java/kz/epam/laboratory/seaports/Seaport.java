package kz.epam.laboratory.seaports;

import kz.epam.laboratory.enums.ShipType;
import kz.epam.laboratory.simulators.ShipArrivingSimulator;
import kz.epam.laboratory.stations.DockStation;
import kz.epam.laboratory.stations.SortStation;

public class Seaport {

    private ShipArrivingSimulator simulator = new ShipArrivingSimulator();
    private SortStation sortStation = new SortStation();
    private DockStation oilTankStation = new DockStation(ShipType.OIL_TANK);
    private DockStation containerStation = new DockStation(ShipType.CONTAINER_SHIP);
    private DockStation smallContainerStation  = new DockStation(ShipType.SMALL_CONTAINER_SHIP);

    public Seaport(){
        sortStation.addStations(oilTankStation,containerStation,smallContainerStation);
    }

    public void startWorking(){
        simulator.setDaemon(true);
        sortStation.setDaemon(true);

        simulator.start();
        sortStation.start();
        oilTankStation.start();
        containerStation.start();
        smallContainerStation.start();

    }

}
