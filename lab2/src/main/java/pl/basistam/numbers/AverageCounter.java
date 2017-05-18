package pl.basistam.numbers;

import java.util.Arrays;

public class AverageCounter {
    private int[] numbers;

    public AverageCounter(int[] numbers) {
        this.numbers = numbers;
    }

    public float count() {
        return getSumOfElements() / numbers.length;
    }

    private float getSumOfElements() {
        return Arrays
                .stream(numbers)
                .sum();
    }
}
