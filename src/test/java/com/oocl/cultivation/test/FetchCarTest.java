package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ck
 * @create 2020-07-24 21:25
 */
public class FetchCarTest {

    @Test
    void should_return_car_when_fetch_car_given_ticket_ParkingBoy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("T0001");
        //when
        Car car = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertNotNull(car);
    }
}
