package pl.basistam.soa.parkingSpaceSensor;

public class Main {
    public static void main(String[] args) {
        ParkingSensors sensors = new ParkingSensors();
        while(true) {
            sensors.enterParking();
        }
    }
}
