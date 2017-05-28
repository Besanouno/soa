package pl.basistam;

import pl.basistam.client.CurrencyExchange;
import pl.basistam.client.CurrencyExchange_Service;

import java.math.BigDecimal;

public class CurrencyExchangeClient {
    public static void main(String[] args) {
        CurrencyExchange service = new CurrencyExchange_Service().getCurrencyExchange();
        //invoke business method
        System.out.println(service.getActualCourse("EUR"));
        System.out.println(service.convertToPln(BigDecimal.TEN,"EUR"));
    }
}
