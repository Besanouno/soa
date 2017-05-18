package pl.basistam.cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarChoiceHelper {
    private Cars cars = new Cars();

    public List<Car> findCars(CarType type, double minimum, double maximum) {
        return cars
                .models
                .stream()
                .filter(c -> c.getType() == type)
                .filter(c -> c.isPriceInRange(minimum, maximum))
                .collect(Collectors.toList());
    }
}
