package com.oocl.cultivation;


import java.util.*;

/**
 * @author ck
 * @create 2020-07-24 19:51
 */
public class ParkingBoy {

    List<ParkingLot> parkingLotList;
    protected Map<Ticket,Car> ticketTable = new HashMap<>();

    public ParkingBoy() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot("P1");
        parkingLotList.add(parkingLot);
        this.parkingLotList = parkingLotList;
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parkCar(Car car) {
        Integer parkingLotNo = parkCarInParkingLot(car);
        if(parkingLotNo == -1){
            return null;
        }
        Ticket ticket = generateTicket(parkingLotNo);
        ticketTable.put(ticket,car);
        return ticket;
    }

    protected Ticket generateTicket(Integer parkingLotNo) {
        UUID uuid = UUID.randomUUID();
        return new Ticket(uuid.toString(),parkingLotNo);
    }

    protected Integer parkCarInParkingLot(Car car){
        if(car == null){
            return -1;
        }
        for(int i = 0; i < parkingLotList.size(); i++){
            ParkingLot parkingLot = parkingLotList.get(i);
            List<Car> carList = parkingLot.getCarList();

            if(carList.contains(car)){
                return -1;
            }

            if(carList.size() >= parkingLot.getCapacity()){
                continue;
            }
            carList.add(car);
            return i;
        }
        System.out.print("Not enough position.\n");
        return -1;
    }

    public Car fetchCar(Ticket ticket) {
        if(ticket == null){
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        Car car = ticketTable.get(ticket);
        ticketTable.remove(ticket);
        if(car == null){
            System.out.print("Unrecognized parking ticket.\n");
            return null;
        }
        return car;
    }
}
