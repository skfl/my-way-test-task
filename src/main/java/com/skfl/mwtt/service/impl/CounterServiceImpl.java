package com.skfl.mwtt.service.impl;

import com.skfl.mwtt.exception.CounterNotFoundException;
import com.skfl.mwtt.repository.CounterRepository;
import com.skfl.mwtt.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    @Override
    @Transactional
    public int setValue(Long counterId, int value) {
        var counter = counterRepository.findById(counterId).orElseThrow(() -> {
            throw new CounterNotFoundException("No Counter with such id were found");
        });
        counter.setVal(value);
        counterRepository.saveAndFlush(counter);
        return value;
    }
}
