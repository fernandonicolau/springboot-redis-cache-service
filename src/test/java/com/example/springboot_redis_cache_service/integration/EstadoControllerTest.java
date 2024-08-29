package com.example.springboot_redis_cache_service.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springboot_redis_cache_service.dto.EstadoDTO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstadoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void buscarTodosOsEstadosTest() {
        ResponseEntity<List<EstadoDTO>> response = restTemplate.exchange(
                "/estados",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EstadoDTO>>() {
                });
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
