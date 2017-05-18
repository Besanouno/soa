package pl.basistam.movies;

import java.math.BigDecimal;

public class Movie {
    private String title;
    private String type;
    private String year;
    private BigDecimal income;

    public Movie(String title, String type, String year, BigDecimal income) {
        this.title = title;
        this.type = type;
        this.year = year;
        this.income = income;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
