package com.prado.walletshares;

import com.prado.walletshares.Infra.SequenceGenerator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void generates_sequency_isCorrect(){
        Long sequence = SequenceGenerator.nextValue(4L);
        assertEquals(5,sequence.intValue());
    }
}