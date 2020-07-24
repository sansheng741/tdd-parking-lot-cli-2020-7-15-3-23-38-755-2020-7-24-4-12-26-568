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
        Car car = new Car("C0001");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        car = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertNotNull(car);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_ticket_and_ParkingBoy_and_2_car_in_parkingLot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car("C0001");
        Car car2 = new Car("C0002");
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);
        //when
        Car car = parkingBoy.fetchCar(ticket1);
        //then
        Assertions.assertEquals(car.getId(),car1.getId());
    }

    @Test
    void should_return_no_car_when_fetch_car_given_wrong_ticket_and_ParkingBoy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("C0001");
        parkingBoy.parkCar(car);
        //when
        Car getCarByWrongTicket = parkingBoy.fetchCar(new Ticket("T0001"));
        //then
        Assertions.assertNull(getCarByWrongTicket);
    }

    @Test
    void should_return_no_car_when_fetch_car_given_no_ticket_and_ParkingBoy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.fetchCar(null);
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_return_no_car_when_fetch_car_given_already_used_ticket_and_ParkingBoy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("C0001");
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car CarByTicket = parkingBoy.fetchCar(ticket);
        Car CarByUsedTicket = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertNull(CarByUsedTicket);
    }
}
