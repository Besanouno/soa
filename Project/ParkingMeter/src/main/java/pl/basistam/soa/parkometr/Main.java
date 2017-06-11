package pl.basistam.soa.parkometr;


import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ParkingMeter parkingMeter = new ParkingMeter();
        while(true) {
            if (parkingMeter.buyTicket()) {
                System.out.println("Bilet poprawny");
            } else {
                System.out.println("Nie udało się przeprowadzić transakcji. Sprawdź poprawność wprowadzonych danych.");
            }
        }
    }
}
