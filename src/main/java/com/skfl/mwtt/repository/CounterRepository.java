package com.skfl.mwtt.repository;

import com.skfl.mwtt.model.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
}
