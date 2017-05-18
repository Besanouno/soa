package pl.basistam.shop;

import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private Map<String, Integer> products = new LinkedHashMap<>();

    public void add(String product, int quantity) {
        if (products.containsKey(product)) {
            Integer oldQuantity = products.get(product);
            products.replace(product, oldQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public void increment(String product) {
        if (products.containsKey(product)) {
            Integer oldQuantity = products.get(product);
            products.replace(product, oldQuantity + 1);
        }
    }

    public void decrement(String product) {
        if (products.containsKey(product)) {
            Integer oldQuantity = products.get(product);
            if (oldQuantity == 1) {
                products.remove(product);
            }
            products.replace(product, oldQuantity - 1);
        }
    }

    public Map<String, Integer> getProducts() {
        return products;
    }
}
