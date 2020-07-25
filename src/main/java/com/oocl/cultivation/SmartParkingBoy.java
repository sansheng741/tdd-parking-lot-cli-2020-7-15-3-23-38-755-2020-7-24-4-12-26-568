package com.oocl.cultivation;

import java.util.List;

/**
 * @author ck
 * @create 2020-07-25 14:46
 */
public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket parkCar(Car car) {
        return null;
    }
}
