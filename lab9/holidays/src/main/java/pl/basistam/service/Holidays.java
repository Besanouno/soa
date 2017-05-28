package pl.basistam.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDate;
import java.time.Month;

@WebService
public class Holidays {

    public Holidays() {

    }

    @WebMethod
        public int getDaysLastToHolidays() {
        LocalDate currentDate = LocalDate.now();
        LocalDate holidayStart = LocalDate.of(getYearOfNextHolidays(), 7, 1);
        return holidayStart.getDayOfYear() - currentDate.getDayOfYear();
    }

    private int getYearOfNextHolidays() {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getMonthValue() > Month.JULY.getValue()
                || currentDate.getMonthValue() == Month.JULY.getValue() && currentDate.getDayOfMonth() > 1) ?
                currentDate.getYear() + 1 :
                currentDate.getYear();
    }
}
