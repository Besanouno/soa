package pl.basistam.soa.parkometr;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Parkometr parkometr = new Parkometr();
        while(true) {
            parkometr.buyTicket();
        }
    }
}
