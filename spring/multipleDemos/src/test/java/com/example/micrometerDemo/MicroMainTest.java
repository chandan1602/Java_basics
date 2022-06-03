package com.example.micrometerDemo;

import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.search.Search;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MicroMainTest {
    @Test
    public void givenGlobalRegistry_whenIncrementAnywhere_thenCounted() {
        class CountedObject {
            private CountedObject() {
                Metrics.counter("objects.instance").increment(1.0);
            }
        }
        Metrics.addRegistry(new SimpleMeterRegistry());

        Metrics.counter("objects.instance").increment();
        new CountedObject();

        Optional<Counter> counterOptional = Optional.ofNullable(Metrics.globalRegistry
                .find("objects.instance").counter());
        assertTrue(counterOptional.isPresent());
        assertTrue(counterOptional.get().count() == 2.0);
    }

    @Test
    public void opsWithCounter() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        Counter counter = Counter
                .builder("instance")
                .description("indicates instance count of the object")
                .tags("dev", "performance")
                .register(registry);

        counter.increment(2.0);

        assertTrue(counter.count() == 2);

        counter.increment(-1);

        assertTrue(counter.count() == 1);
    }

    @Test
    public void opsWithTimer() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        Timer timer = registry.timer("app.event");
        timer.record(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
            } catch (InterruptedException ignored) {
            }
        });

        timer.record(30, TimeUnit.MILLISECONDS);

        assertTrue(2 == timer.count());
        Assertions.assertThat(timer.totalTime(TimeUnit.MILLISECONDS)).isBetween(40.0, 55.0);
    }

    @Test
    public void opsWithLongTaskTimer() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        LongTaskTimer longTaskTimer = LongTaskTimer
                .builder("3rdPartyService")
                .register(registry);

        LongTaskTimer.Sample currentTaskId = longTaskTimer.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException ignored) { }
        long timeElapsed = currentTaskId.stop();

        assertEquals(2L, timeElapsed/((int) 1e6),1L);
    }

    @Autowired
    GuageSetter guageSetter;

    @Test
    public void opsWithGuage() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        List<String> list = new ArrayList<>(4);

        Gauge gauge = Gauge
                .builder("cache.size", list, List::size)
                .register(registry);
        assertTrue(gauge.value() == 0.0);

        list.add("1");

        assertTrue(gauge.value() == 1.0);

        AtomicInteger common = new AtomicInteger(0);
        guageSetter.setGuage("Student", registry, 1);
        guageSetter.setGuage("Teacher", registry, 2);
        guageSetter.setGuage("Student", registry, 1);
        Optional<Search> gauge1 = Optional.of(registry.find("Student"));
        gauge1.ifPresent(value -> System.out.println(value));
//        assertEquals(Objects.requireNonNull(registry.find("Student").gauge()).value(), 1.0);
//        assertEquals(Objects.requireNonNull(registry.find("Teacher").gauge()).value(), 2.0);
    }
}