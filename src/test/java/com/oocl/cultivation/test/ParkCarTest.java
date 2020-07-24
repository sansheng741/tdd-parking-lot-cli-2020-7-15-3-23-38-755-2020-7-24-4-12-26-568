package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * @author ck
 * @create 2020-07-24 19:46
 */
public class ParkCarTest{

    @Test
    void should_return_ticket_when_parkCar_given_car_and_parkingboy() {
        //given
        Car car = new Car("C0001");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_2_ticket_when_parkCar_given_2_car_and_parkingboy(){
        //given
        Car car1 = new Car("C0001");
        Car car2 = new Car("C0002");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);
        //then
        Assertions.assertNotNull(ticket1);
        Assertions.assertNotNull(ticket2);
    }

    @Test
    void should_return_no_ticket_when_parkCar_given_car_and_parkingboy_and_full_ParkingLot(){
        //given
        Car car = new Car("C0001");
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car("C0002");
        Car car2 = new Car("C0003");
        Car car3 = new Car("C0004");
        Car car4 = new Car("C0005");
        Car car5 = new Car("C0006");
        Car car6 = new Car("C0007");
        Car car7 = new Car("C0008");
        Car car8 = new Car("C0009");
        Car car9 = new Car("C00010");
        Car car10 = new Car("C00011");
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        parkingBoy.parkCar(car3);
        parkingBoy.parkCar(car4);
        parkingBoy.parkCar(car5);
        parkingBoy.parkCar(car6);
        parkingBoy.parkCar(car7);
        parkingBoy.parkCar(car8);
        parkingBoy.parkCar(car9);
        parkingBoy.parkCar(car10);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        Assertions.assertNull(ticket);
    }

}