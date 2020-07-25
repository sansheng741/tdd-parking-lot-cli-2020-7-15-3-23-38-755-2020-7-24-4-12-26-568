package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotServiceManager;
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
        boolean isSuccessfullyAdd = parkingLotServiceManager.addParkingBoy(parkingBoy);
        //then
        Assertions.assertTrue(isSuccessfullyAdd);
    }
}
