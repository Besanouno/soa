package pl.basistam.soa.parkingSpaceSensor;

import java.util.Scanner;

public class Parking {
    private Scanner scanner = new Scanner(System.in);

    public void takeParkingSpot() {
        System.out.println("Strefa: ");
        int area = scanner.nextInt();
        System.out.println("Numer miejsca postojowego: ");
        int parkingSpot = scanner.nextInt();

    }
}
