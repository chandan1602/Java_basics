package org.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestCalculator {
    Calculator c = null;
//    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
    @Mock
    CalculatorService calculatorService;

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        c = new Calculator(calculatorService);
    }

    @Test
    public void testPerform() {
        when(calculatorService.add(2,3)).thenReturn(5);
        assertEquals(10, c.perform(2,3));
        verify(calculatorService).add(2,3);
    }
}
