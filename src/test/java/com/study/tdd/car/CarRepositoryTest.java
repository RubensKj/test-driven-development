package com.study.tdd.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName_returnsCar() {
        Car carSaved = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Optional<Car> carOptional = carRepository.findByName("prius");

        assertThat(carOptional.isPresent()).isEqualTo(true);
        assertThat(carOptional.get().getName()).isEqualTo(carSaved.getName());
        assertThat(carOptional.get().getType()).isEqualTo(carSaved.getType());
    }
}