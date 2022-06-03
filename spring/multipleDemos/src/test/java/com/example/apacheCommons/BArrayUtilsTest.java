package com.example.apacheCommons;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BArrayUtilsTest {
    @Test
    public void whenCalledtoString_thenCorrect() {
        String[] array = {"a", "b", "c"};
        assertThat(ArrayUtils.toString(array))
                .isEqualTo("{a,b,c}");
    }

    @Test
    public void whenCalledtoStringIfArrayisNull_thenCorrect() {
        assertThat(ArrayUtils.toString(null, "Array is null")).isEqualTo("Array is null");
    }

    @Test
    public void whenCalledhashCode_thenCorrect() {
        String array[] = {"a", "b", "c"};
        assertThat(ArrayUtils.hashCode(array))
                .isEqualTo(997619);
    }

    @Test
    public void whenCalledtoMap_thenCorrect() {
        String array[][] = {
                {"1", "one"},
                {"2", "two"},
                {"3", "three"}
        };
        Map map = new HashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        assertThat(ArrayUtils.toMap(array)).isEqualTo(map);
    }

    @Test
    public void whenCalledisSameLength_thenCorrect() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        assertThat(ArrayUtils.isSameLength(arr1, arr2)).isTrue();
    }

    @Test
    public void whenCalledIndexOf_thenCorrect() {
        int[] arr = {1,2,3};
        assertThat(ArrayUtils.indexOf(arr, 1, 0))
                .isEqualTo(0);
    }
}