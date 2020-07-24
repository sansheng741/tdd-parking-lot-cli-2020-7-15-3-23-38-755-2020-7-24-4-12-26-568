package com.oocl.cultivation;

/**
 * @author ck
 * @create 2020-07-24 20:32
 */
public class ParkingLot {
    int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
