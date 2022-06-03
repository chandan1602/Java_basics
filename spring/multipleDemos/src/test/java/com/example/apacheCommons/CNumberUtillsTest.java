package com.example.apacheCommons;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CNumberUtillsTest {
    @Test
    public void whenCalledcompareWithIntegers_thenCorrect() {
        assertThat(NumberUtils.compare(1,1)).isEqualTo(0);
    }

    @Test
    public void whenCalledcompareWithLongs_thenCorrect() {
        assertThat(NumberUtils.compare(1L, 1L)).isEqualTo(0);
    }

    @Test
    public void whenCalledcreateNumber_thenCorrect() {
        assertThat(NumberUtils.createNumber("123456")).isEqualTo(123456);
    }

    @Test
    public void whenCalledisDigits_thenCorrect() {
        assertThat(NumberUtils.isDigits("123456")).isTrue();
    }

    @Test
    public void whenCalledMinMaxwithIntegerArray_thenCorrect() {
        int array[] = {1,2,3,4,5,6};
        assertThat(NumberUtils.max(array)).isEqualTo(6);
        assertThat(NumberUtils.min(array)).isEqualTo(1);
    }

    @Test
    public void whenCalledminwithByteArray_thenCorrect() {
        byte array[] = {1,2,3,4,5,6};
        assertThat(NumberUtils.min(array)).isEqualTo((byte)1);
    }
}