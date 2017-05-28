package example;

import pl.basistam.Holidays;

public class HelloWorldClient {
  public static void main(String[] argv) {
      Holidays service = new pl.basistam.Holidays_Service().getHolidays();
      //invoke business method
      System.out.println(service.getDaysLastToHolidays());
  }
}
