package com.example.apacheCommons;

import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DFractionUtilsTest {
    @Test
    public void whenCalledgetFraction_thenCorrect() {
        assertThat(Fraction.getFraction(5,6)).isInstanceOf(Fraction.class);
    }

    @Test
    public void givenTwoFractionInstances_whenCalledadd_thenCorrect() {
        Fraction f1 = Fraction.getFraction(1,4);
        Fraction f2 = Fraction.getFraction(3,4);
        assertThat(f1.add(f2).toString()).isEqualTo("1/1");
    }

    @Test
    public void givenTwoFractionInstances_whenCalledsubstract_thenCorrect() {
        Fraction f1 = Fraction.getFraction(3,4);
        Fraction f2 = Fraction.getFraction(1,4);
        assertThat(f1.subtract(f2).toString()).isEqualTo("1/2");
    }

    @Test
    public void whenCalledgetJavaHome_thenCorrect() {
        assertThat(SystemUtils.getJavaHome())
                .isEqualTo(new File("/opt/homebrew/Cellar/openjdk@11/11.0.12/libexec/openjdk.jdk/Contents/Home"));
    }

    @Test
    public void whenCalledgetUserHome_thenCorrect() {
        assertThat(SystemUtils.getUserHome())
                .isEqualTo(new File("/Users/chandanbansal"));
    }

    @Test
    public void whenCalledisJavaVersionAtLeast_thenCorrect() {
        assertThat(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT)).isTrue();
    }
}