package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ck
 * @create 2020-07-25 16:29
 */
public class ParkingLotServiceManager {

    private List<ParkingBoy> parkingBoyList = new ArrayList<>();


    public ParkingLotServiceManager() {
    }


    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public Ticket specifyParkingBoyToParkCar() {
        return new Ticket("T0001",0);
    }

    public Car specifyParkingBoyToFetchCar() {
        return new Car("C0001");
    }
}
