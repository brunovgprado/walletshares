package com.prado.walletshares.Infra;

public class SequenceGenerator {
    private static long NEXT_VALUE = 1;

    public static long nextValue(Long sequenceMax){
        return (sequenceMax + NEXT_VALUE);
    }
}
