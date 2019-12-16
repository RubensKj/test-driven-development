package com.study.tdd.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebFluxTest
public class CarWebTestClientTest {

    // THESE MAKE A TEST DIRECTLY IN THE CONTROLLER IF WE ARE USING SPRING SECURITY

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getCar_WithName_returnsCar() {
        Car car = new Car("prius", "hybrid");
        given(carRepository.findByName("prius")).willReturn(Optional.of(car));

        this.webTestClient.get().uri("/api/cars/{name}", "prius")
                .exchange().expectStatus().isOk()
                .expectBody()
                .jsonPath("name").isEqualTo("prius")
                .jsonPath("type").isEqualTo("hybrid");
    }
}
