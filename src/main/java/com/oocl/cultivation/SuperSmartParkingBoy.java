package com.oocl.cultivation;

import java.util.List;

/**
 * @author ck
 * @create 2020-07-25 15:45
 */
public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket parkCar(Car car7) {
        return null;
    }
}
