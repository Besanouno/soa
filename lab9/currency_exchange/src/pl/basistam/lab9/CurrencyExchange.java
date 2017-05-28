package pl.basistam.lab9;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebService
public class CurrencyExchange {

  private static Map<String, BigDecimal> courses;

  static {
    courses = new HashMap<>();
    courses.put("PLN", BigDecimal.ONE);
    courses.put("EUR", new BigDecimal("4.1803"));
    courses.put("GBP", new BigDecimal("4.7942"));
    courses.put("USD", new BigDecimal("3.7248"));
    courses.put("CHF", new BigDecimal("3.8381"));
  }

  @WebMethod
  public BigDecimal getActualCourse(String currency) {
    if (!courses.containsKey(currency))
      throw new RuntimeException("Wrong currency symbol");

    return courses.get(currency);
  }

  @WebMethod
  public BigDecimal convertToPln(BigDecimal amount, String currency) {
    BigDecimal course = getActualCourse(currency);
    return amount.multiply(course);
  }
}
