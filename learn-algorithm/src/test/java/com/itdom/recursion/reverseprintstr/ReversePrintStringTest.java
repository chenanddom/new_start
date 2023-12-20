package com.itdom.recursion.reverseprintstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePrintStringTest {

    @Test
    void reversePrintStr() {
        ReversePrintString reversePrintString = new ReversePrintString();
        reversePrintString.reversePrintStr(0,"abcdef");
    }
}