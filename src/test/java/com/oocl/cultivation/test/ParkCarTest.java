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
public class ParkCarTest {

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
}
