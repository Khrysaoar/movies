package com.challenge.movies.service;

import com.challenge.movies.model.Movie;
import com.challenge.movies.model.MovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    private static final String API_URL = "https://wiremock.dev.eroninternational.com/api/movies/search?page=";

    public List<String> getDirectors(int threshold) {
        Map<String, Integer> directorCount = new HashMap<>();
        int currentPage = 1;
        int totalPages = Integer.MAX_VALUE;

        while (currentPage <= totalPages) {
            String url = API_URL + currentPage;
            RestTemplate restTemplate = new RestTemplate();

            MovieResponse movieResponse = restTemplate.getForObject(url, MovieResponse.class);

            if (movieResponse != null) {
                totalPages = movieResponse.getTotal_pages();
                currentPage++;

                for (Movie movie : movieResponse.getData()) {
                    if (Integer.parseInt(movie.getYear()) > 2010) {
                        directorCount.merge(movie.getDirector(), 1, Integer::sum);
                    }
                }
            } else {
                break;
            }
        }

        return directorCount.entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}