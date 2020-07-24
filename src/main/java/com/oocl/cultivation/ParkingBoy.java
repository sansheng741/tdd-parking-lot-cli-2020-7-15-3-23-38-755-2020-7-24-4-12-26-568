package com.oocl.cultivation;


import java.util.*;

/**
 * @author ck
 * @create 2020-07-24 19:51
 */
public class ParkingBoy {

    List<ParkingLot> parkingLotList = new ArrayList<>();
    private Map<Ticket,Car> ticketTable = new HashMap<>();

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parkCar(Car car) {
        boolean isPark = parkCarInParkingLot(car);
        if(!isPark){
            return null;
        }
        Ticket ticket = generateTicket();
        ticketTable.put(ticket,car);
        return ticket;
    }

    private Ticket generateTicket() {
        UUID uuid = UUID.randomUUID();
        return new Ticket(uuid.toString());
    }

    private boolean parkCarInParkingLot(Car car){
        if(car == null){
            return false;
        }
        List<Car> carList = parkingLot.getCarList();
        if(carList.size() >= 10){
            System.out.print("Not enough position.\n");
            return false;
        }
        if(carList.contains(car)){
            return false;
        }
        carList.add(car);
        return true;
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
