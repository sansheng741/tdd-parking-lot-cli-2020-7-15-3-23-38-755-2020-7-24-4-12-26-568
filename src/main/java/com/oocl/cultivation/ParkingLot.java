package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ck
 * @create 2020-07-24 20:32
 */
public class ParkingLot {

    private String id;
    private int capacity;
    private List<Car> carList = new ArrayList<>();

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(String id) {
        this();
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
