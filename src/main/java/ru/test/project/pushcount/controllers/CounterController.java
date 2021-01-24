package ru.test.project.pushcount.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.pushcount.entities.CounterEntity;
import ru.test.project.pushcount.exceptions.ResourceNotFoundException;
import ru.test.project.pushcount.services.CounterService;

@RestController
@RequestMapping("/api/v1/counter")
@AllArgsConstructor
public class CounterController {

    public static final long COUNTER_ID = 1L;
    private final CounterService counterService;

    @GetMapping(produces = "application/json")
    public CounterEntity getCounterById() {
        return counterService.findById(COUNTER_ID).orElseThrow(() ->
                new ResourceNotFoundException("ProductEntity with id=" + COUNTER_ID + " doesn't exists"));
    }

    @GetMapping("/inc/{counter_id}")
    public void incCounter(@PathVariable(name = "counter_id") Long counterId) {
        counterService.save(counterId);
    }

}
