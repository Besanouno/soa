package pl.basistam.soa.main.carPark;

import lombok.*;

import java.time.LocalDateTime;

@Data
class ParkingSpot {

    public enum State {
        IDLE, WAITING_FOR_PAYMENT, PAID
    }

    public ParkingSpot(int id, int area) {
        this.id = id;
        this.area = area;
    }

    private int id;
    private int area;
    private State state = State.IDLE;
    private LocalDateTime timeOfParking;
    private LocalDateTime timeOfTicketPurchase;
    private LocalDateTime timeOfTicketExpiration;

    public boolean take() {
        if (state != State.IDLE) {
            return false;
        }
        state = State.WAITING_FOR_PAYMENT;
        timeOfParking = LocalDateTime.now();
        return true;
    }

    public boolean pay(LocalDateTime timeOfTicketPurchase,
                       LocalDateTime timeOfTicketExpiration) {
        if (state != State.WAITING_FOR_PAYMENT)
            return false;
        state = State.PAID;
        this.timeOfTicketPurchase = timeOfTicketPurchase;
        this.timeOfTicketExpiration = timeOfTicketExpiration;
        return true;
    }

    public boolean release() {
        if (state == State.IDLE)
            return false;
        timeOfParking = null;
        timeOfTicketExpiration = null;
        timeOfTicketPurchase = null;
        return true;
    }
}
