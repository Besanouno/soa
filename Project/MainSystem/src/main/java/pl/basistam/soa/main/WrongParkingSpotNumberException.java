package pl.basistam.soa.main;

public class WrongParkingSpotNumberException extends Exception {
    private String message;

    public WrongParkingSpotNumberException(String msg) {
        this.message = msg;
    }

    @Override
    public String toString() {
        return message;
    }
}
