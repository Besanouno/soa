package pl.basistam.soa.parkingSpaceSensor;

import pl.basistam.soa.parkingSpaceSensor.client.ParkingSensorsService;
import pl.basistam.soa.parkingSpaceSensor.client.ParkingSensorsService_Service;

import java.util.Scanner;

public class ParkingSensors {
    private Scanner scanner = new Scanner(System.in);
    private ParkingSensorsService service
            = new ParkingSensorsService_Service().getParkingSensorsService();

    private final static int TAKE = 1;
    private final static int RELEASE = 2;

    public void enterParking() {
        try {
            System.out.println("1. Zajęcie/ 2. Zwolnienie miejsca (Wybierz 1 lub 2): ");
            int choice = scanner.nextInt();
            System.out.println("Strefa: ");
            int area = scanner.nextInt();
            System.out.println("Numer miejsca postojowego: ");
            int parkingSpot = scanner.nextInt();

            boolean result = false;
            if (choice == TAKE) {
                result = service.takeParkingSpot(area, parkingSpot);
            } else if (choice == RELEASE) {
                result = service.takeParkingSpot(area, parkingSpot);
            } else {
                throw new Exception();
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Nastąpił błąd, spróbuj ponownie");
        }
    }
}
