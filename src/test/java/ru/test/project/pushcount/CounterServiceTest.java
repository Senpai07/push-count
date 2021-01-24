package ru.test.project.pushcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.test.project.pushcount.entities.CounterEntity;
import ru.test.project.pushcount.repositories.CounterRepository;
import ru.test.project.pushcount.services.CounterService;

import java.util.Optional;

@SpringBootTest
public class CounterServiceTest {
    @Autowired
    private CounterService counterService;

    @MockBean
    private CounterRepository counterRepository;

    @Test
    public void findOneCategoryTest() {
        CounterEntity counterFromDb = new CounterEntity();
        counterFromDb.setQuantity(1);

        Mockito.doReturn(Optional.of(counterFromDb)).when(counterRepository).findById(1L);

        CounterEntity categoryMilk = counterService.findById(1L).get();

        Assertions.assertNotNull(categoryMilk);

        Assertions.assertEquals(1, categoryMilk.getQuantity());

        Mockito.verify(counterRepository, Mockito.times(1))
                .findById(ArgumentMatchers.eq(1L));
    }

}
