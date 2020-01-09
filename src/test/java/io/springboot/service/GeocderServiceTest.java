package io.springboot.service;

import io.springboot.entities.Site;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GeocderServiceTest {
    private Logger logger = LoggerFactory.getLogger(GeocderServiceTest.class);

    @Autowired
    private GeocderService geocderService;

    @Test
    void testGetLatLng() {
        Site google = geocderService.getLatLng( "1600 Ampitheatre Parkway", "Mountain View", "CA");
        logger.info(String.valueOf(google));
        assertEquals(37.42, google.getLatitude(), 0.01);
        assertEquals(-122.08, google.getLongitude(), 0.01);
    }
    @Test
    void testGetLatLngWithoutStreet() {
        Site google = geocderService.getLatLng( "Boston", "MA");
        logger.info(String.valueOf(google));
        assertEquals(42.36, google.getLatitude(), 0.01);
        assertEquals(-71.06, google.getLongitude(), 0.01);
    }
}
