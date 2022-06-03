package com.example.micrometerDemo;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.concurrent.atomic.AtomicInteger;

class GuageSetter {
    AtomicInteger common = new AtomicInteger(0);
    public void setGuage(String name, SimpleMeterRegistry registry, int value) {
        registry.gauge(name, common);
        common.set(value);
    }
}