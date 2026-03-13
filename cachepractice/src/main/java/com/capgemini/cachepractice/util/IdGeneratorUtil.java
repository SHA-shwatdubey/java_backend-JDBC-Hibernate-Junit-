package com.capgemini.cachepractice.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGeneratorUtil {

    private final AtomicLong sequence = new AtomicLong(1);

    public long nextId() {
        return sequence.getAndIncrement();
    }
}

