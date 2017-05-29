package pl.basistam.soa.parkingSpaceSensor;

import pl.basistam.soa.parkingSpaceSensor.client.ParkingSensorsService;
import pl.basistam.soa.parkingSpaceSensor.client.ParkingSensorsService_Service;

import java.util.Scanner;

public class ParkingSensors {
    private Scanner scanner = new Scanner(System.in);

    private ParkingSensorsService service
            = new ParkingSensorsService_Service().getParkingSensorsService();

    public void enterParking() {
        System.out.println("Strefa: ");
        int area = scanner.nextInt();
        System.out.println("Numer miejsca postojowego: ");
        int parkingSpot = scanner.nextInt();

        boolean result = service.takeParkingSpot(area, parkingSpot);
        System.out.println(result);
    }
}
