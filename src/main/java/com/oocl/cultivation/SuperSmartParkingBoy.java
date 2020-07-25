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
    protected Integer parkCarInParkingLot(Car car) {
        if(car == null){
            return -1;
        }
        ParkingLot largerAvailablePositionRateParkingLot = null;
        double parkingLotAvailablePositionRate = 0;
        int parkingLotNo = -1;
        for(int i = 0; i < parkingLotList.size(); i++) {
            ParkingLot parkingLot = parkingLotList.get(i);
            if(parkingLot.getCarList().contains(car)){
                return -1;
            }
            double availablePositionRate = (double) (parkingLot.getCapacity() - parkingLot.getCarList().size())/parkingLot.getCapacity();

            if (parkingLotAvailablePositionRate < availablePositionRate) {
                parkingLotAvailablePositionRate = availablePositionRate;
                largerAvailablePositionRateParkingLot = parkingLot;
                parkingLotNo = i;
            }
        }
        if(largerAvailablePositionRateParkingLot != null && largerAvailablePositionRateParkingLot.getCarList().size() >= largerAvailablePositionRateParkingLot.getCapacity()){
            System.out.print("Not enough position.\n");
            return  -1;
        }
        largerAvailablePositionRateParkingLot.getCarList().add(car);
        return parkingLotNo;
    }
}
