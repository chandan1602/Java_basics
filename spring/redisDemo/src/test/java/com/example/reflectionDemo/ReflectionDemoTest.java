package com.example.reflectionDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class ReflectionDemoTest {
    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new ReflectionDemo();
        Field[] fields = person.getClass().getDeclaredFields();
        List<String> actualFieldNames = Arrays.stream(fields).map(x -> x.getName()).collect(Collectors.toList());
        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }
}
