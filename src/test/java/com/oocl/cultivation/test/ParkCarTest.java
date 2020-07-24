package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
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
}
