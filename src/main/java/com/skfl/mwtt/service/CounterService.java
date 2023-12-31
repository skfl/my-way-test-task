package com.skfl.mwtt.service;

public interface CounterService {

    int setValue(Long counterId, int value);

    int getCounterValue(Long id);

    int increment(Long id);
}
