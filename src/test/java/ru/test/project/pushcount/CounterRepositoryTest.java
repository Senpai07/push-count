package ru.test.project.pushcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.test.project.pushcount.entities.CounterEntity;
import ru.test.project.pushcount.repositories.CounterRepository;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CounterRepositoryTest {

    @Autowired
    private CounterRepository counterRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void categoryRepositoryTest() {
        CounterEntity counter = new CounterEntity();
        counter.setQuantity(1);
        testEntityManager.persist(counter);
        testEntityManager.flush();

        List<CounterEntity> countersList = counterRepository.findAll();

        Assertions.assertEquals(2, countersList.size());
        Assertions.assertEquals(1, countersList.get(0).getId());
    }

    @Test
    public void initDbTest() {
        List<CounterEntity> countersList = counterRepository.findAll();
        Assertions.assertEquals(1, countersList.size());
    }
}
