package ru.test.project.pushcount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.test.project.pushcount.entities.CounterEntity;

@Repository
public interface CounterRepository extends JpaRepository<CounterEntity, Long>, JpaSpecificationExecutor<CounterEntity> {
}
