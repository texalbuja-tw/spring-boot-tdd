package io.springboot.service;

import io.springboot.entities.Response;
import io.springboot.entities.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocderService {
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "AIzaSyBhfqDcbyGch8pdwaOk4QVLP_TMj5z6Smk";

    private RestTemplate restTemplate;

    @Autowired
    public GeocderService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Site getLatLng(String... address) {
        String joinedAddress = String.join(",", address);
        String encodedAddress = "";
        encodedAddress = URLEncoder.encode(joinedAddress, StandardCharsets.UTF_8);

        Response response = restTemplate.getForObject(String.format("%s?address=%s&key=%s",
                BASE, encodedAddress, KEY), Response.class);
        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }
}
