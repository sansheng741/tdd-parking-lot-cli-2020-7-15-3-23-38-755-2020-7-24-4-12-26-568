package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ck
 * @create 2020-07-24 19:46
 */
public class ParkCarTest{
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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

    @Test
    void should_return_no_ticket_when_parkCar_given_car_already_in_ParkingLot_and_parkingboy(){
        //given
        Car car = new Car("C0001");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket1 = parkingBoy.parkCar(car);
        Ticket ticket2 = parkingBoy.parkCar(car);
        //then
        Assertions.assertNull(ticket2);
    }

    @Test
    void should_return_no_ticket_when_parkCar_given_no_car_and_parkingboy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.parkCar(null);
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_message_not_enouth_position_when_parkCar_given_parkingBoy_and_Car_and_full_parkingLot() {
        System.setOut(new PrintStream(outContent));
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
        Assertions.assertEquals("Not enough position.\n", systemOut());
    }
    private String systemOut() {
        return outContent.toString();
    }


    @Test
    void should_park_cars_to_the_second_parking_lot_when_partCar_given_ParkingBoy_car_2_partingLot() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot("P1");
        ParkingLot parkingLot2 = new ParkingLot("P2");
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        Car car = new Car("C0001");

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
        Assertions.assertEquals(1,ticket.getParkingLotNo());
    }


    @Test
    void should_park_car_in_parkingLot_2_parkCar_given_car_parkingBoy_parkingLot_1_and_parkingLot_2() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot("P1");
        ParkingLot parkingLot2 = new ParkingLot("P2");
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        SmartParkingBoy smartPakingBoy = new SmartParkingBoy(parkingLotList);

        Car car1 = new Car("C0001");
        Car car2 = new Car("C0002");
        Car car3 = new Car("C0003");
        List<Car> parkingLot1CarList = parkingLot1.getCarList();
        parkingLot1CarList.add(car1);
        parkingLot1CarList.add(car2);
        parkingLot1CarList.add(car3);

        Car car4 = new Car("C0004");
        Car car5 = new Car("C0005");
        List<Car> parkingLot2CarList = parkingLot2.getCarList();
        parkingLot2CarList.add(car4);
        parkingLot2CarList.add(car5);

        Car car6 = new Car("C0006");
        //when
        Ticket ticket = smartPakingBoy.parkCar(car6);
        //then
        Assertions.assertEquals(1,ticket.getParkingLotNo());
    }
}
