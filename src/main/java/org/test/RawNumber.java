package org.test;

public class RawNumber<T extends Number>{

    public T getVal(){
        return (T)new Object();
    }
}
