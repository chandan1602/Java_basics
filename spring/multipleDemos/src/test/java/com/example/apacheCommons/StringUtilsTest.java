package com.example.apacheCommons;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    public void whenCalledisBlank_thenCorrect() {
        assertThat(StringUtils.isBlank("")).isTrue();
    }

    @Test
    public void whenCalledisEmpty_thenCorrect() {
        assertThat(StringUtils.isEmpty("")).isTrue();
    }

    @Test
    public void whenCalledisAllLowerCase_thenCorrect() {
        assertThat(StringUtils.isAllLowerCase("abd")).isTrue();
    }

    @Test
    public void whenCalledisAlpha_thenCorrect() {
        assertThat(StringUtils.isAlpha("abc")).isTrue();
    }

    @Test
    public void whenCalledisAlphanumeric_thenCorrect() {
        assertThat(StringUtils.isAlphanumeric("abc123")).isTrue();
    }


}