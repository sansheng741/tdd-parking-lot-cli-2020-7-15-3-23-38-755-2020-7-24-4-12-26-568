package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author ck
 * @create 2020-07-24 21:25
 */
public class FetchCarTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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
        Assertions.assertEquals(car.getId(), car1.getId());
    }

    @Test
    void should_return_no_car_when_fetch_car_given_wrong_ticket_and_ParkingBoy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("C0001");
        parkingBoy.parkCar(car);
        //when
        Car getCarByWrongTicket = parkingBoy.fetchCar(new Ticket("T0001",1));
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

    @Test
    void should_print_message_unrecognized_parking_ticket_when_fetchCar_given_ParkingBoy_and_wrong_ticket() {
        System.setOut(new PrintStream(outContent));

        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("C0001");
        parkingBoy.parkCar(car);
        //when
        car = parkingBoy.fetchCar(new Ticket("T0001",1));
        //then
        Assertions.assertEquals("Unrecognized parking ticket.\n", systemOut());
    }

    private String systemOut() {
        return outContent.toString();
    }


    @Test
    void should_print_message_unrecognized_parking_ticket_when_fetchCar_given_ParkingBoy_and_already_used_ticket() {
        System.setOut(new PrintStream(outContent));

        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("C0001");
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car CarByTicket = parkingBoy.fetchCar(ticket);
        Car CarByUsedTicket = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertEquals("Unrecognized parking ticket.\n", systemOut());
    }

    @Test
    void should_print_message_please_provide_your_parking_ticket_when_fetchCar_given_ParkingBoy_and_no_ticket() {
        System.setOut(new PrintStream(outContent));

        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.fetchCar(null);
        //then
        Assertions.assertEquals("Please provide your parking ticket.\n", systemOut());
    }

}
