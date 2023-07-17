package com.skfl.mwtt.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CounterNotFoundException extends RuntimeException {

    public CounterNotFoundException(String message) {
        super(message);
    }
}
