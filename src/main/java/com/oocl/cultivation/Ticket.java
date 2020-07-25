package com.oocl.cultivation;

import java.util.Objects;

/**
 * @author ck
 * @create 2020-07-24 19:51
 */
public class Ticket {
    private String id;
    private Integer parkingLotNo;


    public Ticket(String id, Integer parkingLotNo) {
        this.id = id;
        this.parkingLotNo = parkingLotNo;
    }

    public Integer getParkingLotNo() {
        return parkingLotNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id) &&
                parkingLotNo.equals(ticket.parkingLotNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkingLotNo);
    }
}
