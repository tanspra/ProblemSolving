package org.utility;

public enum Roman {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    private final String roman;
    private final int val;

    Roman(String roman, int val) {
        this.roman = roman;
        this.val = val;
    }

}