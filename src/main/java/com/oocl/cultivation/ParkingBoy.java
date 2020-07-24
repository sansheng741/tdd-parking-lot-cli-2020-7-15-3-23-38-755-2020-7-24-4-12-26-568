package com.oocl.cultivation;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ck
 * @create 2020-07-24 19:51
 */
public class ParkingBoy {

    private ParkingLot parkingLot = new ParkingLot();
    private Map<Ticket,Car> ticketTable = new HashMap<>();

    public ParkingBoy() {
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
            return false;
        }
        if(carList.contains(car)){
            return false;
        }
        carList.add(car);
        return true;
    }

    public Car fetchCar(Ticket ticket) {
        Car car = ticketTable.get(ticket);
        ticketTable.remove(ticket);
        System.out.print("Unrecognized parking ticket.\n");
        return car;
    }
}
