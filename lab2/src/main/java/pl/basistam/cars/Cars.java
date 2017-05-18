package pl.basistam.cars;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public final List<Car> models = new ArrayList<Car>() {
        {
            add(new Car("Opel Vectra", 2000.0, CarType.SPORT));
            add(new Car("BMW X3", 25000.0, CarType.LUXURY));
            add(new Car("Mercedes C Class", 140000.0, CarType.LUXURY));
            add(new Car("Rolls-Royce Ghost", 850000.0, CarType.LUXURY));
            add(new Car("Tesla Model S", 240000.0, CarType.LUXURY));
            add(new Car("Ford Fiesta", 6000.0, CarType.STANDARD));
            add(new Car("Fiat 126p", 700.0, CarType.STANDARD));
            add(new Car("Citroen C4", 20000.0, CarType.STANDARD));
            add(new Car("Renault Megane", 10000.0, CarType.STANDARD));
            add(new Car("Skoda Octavia", 11000.0, CarType.STANDARD));
            add(new Car("Seat Leon", 18000.0, CarType.STANDARD));
            add(new Car("Koenigsegg Regera", 7000000.0, CarType.SPORT));
            add(new Car("Lamborghini Gallardo", 290000.0, CarType.SPORT));
            add(new Car("Aston Martin DB9", 500000.0, CarType.LUXURY));
            add(new Car("Porsche 911", 280000.0, CarType.SPORT));
            add(new Car("McLaren Altul", 800000.0, CarType.SPORT));
        }
    };
}
