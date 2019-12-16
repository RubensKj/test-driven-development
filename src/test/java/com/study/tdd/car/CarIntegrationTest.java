package com.study.tdd.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarIntegrationTest {

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCar_returnsCarDetails() {
        given(carRepository.findByName("prius")).willReturn(Optional.of(new Car("prius", "hybrid")));

        ResponseEntity<Car> response = restTemplate.getForEntity("/api/cars/prius", Car.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }
}
