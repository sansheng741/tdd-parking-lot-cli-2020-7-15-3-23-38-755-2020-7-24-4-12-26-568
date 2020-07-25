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
        Integer parkingLotNo = parkCarInParkingLot(car);
        if(parkingLotNo == -1){
            return null;
        }
        Ticket ticket = generateTicket(parkingLotNo);
        ticketTable.put(ticket,car);
        return ticket;
    }

    @Override
    protected Integer parkCarInParkingLot(Car car) {
        if(car == null){
            return -1;
        }
        ParkingLot moreEmptyPositionsParkLog = null;
        int parkingLotEmptyPositions = 0;
        int parkingLotNo = -1;
        for(int i = 0; i < parkingLotList.size(); i++) {
            ParkingLot parkingLot = parkingLotList.get(i);
            if(parkingLot.getCarList().contains(car)){
                return -1;
            }
            int emptyPosition = parkingLot.getCapacity() - parkingLot.getCarList().size();
            if (parkingLotEmptyPositions < emptyPosition) {
                moreEmptyPositionsParkLog = parkingLot;
                parkingLotEmptyPositions = emptyPosition;
                parkingLotNo = i;
            }
        }
        if(moreEmptyPositionsParkLog != null && moreEmptyPositionsParkLog.getCarList().size() >= moreEmptyPositionsParkLog.getCapacity()){
            System.out.print("Not enough position.\n");
            return  -1;
        }
        moreEmptyPositionsParkLog.getCarList().add(car);
        return parkingLotNo;
    }
}
