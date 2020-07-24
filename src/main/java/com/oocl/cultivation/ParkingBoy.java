package com.oocl.cultivation;


import java.util.List;

/**
 * @author ck
 * @create 2020-07-24 19:51
 */
public class ParkingBoy {

    private ParkingLot parkingLot = new ParkingLot();

    public ParkingBoy() {
    }


    public Ticket parkCar(Car car) {
        boolean isPark = parkCarInParkingLot(car);
        if(!isPark){
            return null;
        }
        return new Ticket();
    }

    private boolean parkCarInParkingLot(Car car){
        List<Car> carList = parkingLot.getCarList();
        if(carList.size() >= 10){
            return false;
        }
        carList.add(car);
        return true;
    }
}
