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

    @Override
    public int getCounterValue(Long id) {
        var counter = counterRepository.findById(id).orElseThrow(() -> {
            throw new CounterNotFoundException("No Counter with such id were found");
        });
        return counter.getVal();
    }

    @Override
    public int increment(Long id) {
        var counter = counterRepository.findById(id).orElseThrow(() -> {
            throw new CounterNotFoundException("No Counter with such id were found");
        });

        var newVal = counter.getVal() + 1;
        counter.setVal(newVal);
        counterRepository.saveAndFlush(counter);
        return newVal;
    }
}
