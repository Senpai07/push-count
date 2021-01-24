package ru.test.project.pushcount.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.project.pushcount.entities.CounterEntity;
import ru.test.project.pushcount.exceptions.ResourceNotFoundException;
import ru.test.project.pushcount.repositories.CounterRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CounterService {
    private final CounterRepository counterRepository;

    public Optional<CounterEntity> findById(Long id) {
        return counterRepository.findById(id);
    }

    public void save(Long id) {
        CounterEntity counterEntity = counterRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ProductEntity with id=" + id + " doesn't exists"));
        counterEntity.setQuantity(counterEntity.getQuantity() + 1);
        counterRepository.save(counterEntity);
    }

}
