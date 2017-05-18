package pl.basistam.cars;

public class Car {
    private String brand;
    private double price;
    private CarType type;

    public Car(String brand, double price, CarType type) {
        this.brand = brand;
        this.price = price;
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    public boolean isPriceInRange(double minimum, double maximum) {
        return price >= minimum && price <= maximum;
    }

    @Override
    public String toString() {
        return brand + ": " + price + " PLN";
    }
}
