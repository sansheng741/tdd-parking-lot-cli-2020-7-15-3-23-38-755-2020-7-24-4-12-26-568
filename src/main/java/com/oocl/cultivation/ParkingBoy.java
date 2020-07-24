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
        return new Ticket("T0001");
    }

    private boolean parkCarInParkingLot(Car car){
        if(car == null){
            return false;
        }
        List<Car> carList = parkingLot.getCarList();
        if(carList.size() >= 10){
            return false;
        }
        if(carList.contains(car)){
            return false;
        }
        carList.add(car);
        return true;
    }

    public Car fetchCar(Ticket ticket) {
        return new Car("C0001");
    }
}
