package pl.basistam.movies;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movies = new ArrayList<>();

    public Movies() {
        movies.add(new Movie("Ojciec chrzestny", "dramat", "1972", new BigDecimal("120000000")));
        movies.add(new Movie("Pluton", "wojenny", "1986", new BigDecimal("50000000")));
        movies.add(new Movie("Nagi instynkt", "thriller", "1992", new BigDecimal("1000000000")));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
