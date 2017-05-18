package pl.basistam.beer.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeerExpert {
    private Map<String, String> brands = new LinkedHashMap<>();

    public BeerExpert() {
        brands.put("Perla", "miodowe");
        brands.put("Zywiec", "ciemne");
        brands.put("Guiness", "ciemne");
        brands.put("Harnas", "jasne");
        brands.put("Lech", "jasne");
        brands.put("Kozel", "pszeniczne");
        brands.put("Holba", "pszeniczne");
        brands.put("Fortuna", "miodowe");
    }
    public List<String> getBrands(String color) {
        return brands.entrySet()
                .stream()
                .filter(e -> color.equals(e.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
