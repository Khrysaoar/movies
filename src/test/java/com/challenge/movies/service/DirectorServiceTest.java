package com.challenge.movies.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DirectorServiceTest {

    @Autowired
    private DirectorService directorService;

    @Test
    void testGetDirectorsAboveThreshold() {
        // Call the service method
        List<String> response= directorService.getDirectors(4);

        // Assert that the response is not null and the expected number of movies are returned
        assertNotNull(response);
        assertEquals(1, response.size());  // Expecting 1 movie in the response
        assertEquals("Woody Allen", response.get(0));
    }
}