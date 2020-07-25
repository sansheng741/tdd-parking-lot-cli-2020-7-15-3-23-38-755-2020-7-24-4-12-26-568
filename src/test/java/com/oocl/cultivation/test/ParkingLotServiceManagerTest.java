package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotServiceManager;
import com.oocl.cultivation.Ticket;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author ck
 * @create 2020-07-25 16:19
 */
public class ParkingLotServiceManagerTest {
    @Test
    public void should_add_parkingBoys_to_management_list_when_add_parkingBoy_given_ParkingLotServiceManager_and_ParkingBoy_() {

        //given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        //then
        Assertions.assertTrue(parkingLotServiceManager.getParkingBoyList().contains(parkingBoy));
    }

    @Test
    public void should_return_car_when_specify_ParkingBoy_To_ParkCar_given_ParkingLotServiceManager_and_ParkingBoy_in_ManagementList() {

        //given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingLotServiceManager.addParkingBoy(parkingBoy);
        //when
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkCar();
        //then
        Assertions.assertNotNull(ticket);
    }
}
