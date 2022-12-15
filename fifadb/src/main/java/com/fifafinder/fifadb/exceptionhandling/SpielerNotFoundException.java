package com.fifafinder.fifadb.exceptionhandling;

public class SpielerNotFoundException extends RuntimeException {
    public SpielerNotFoundException(String m){
        super(m);
    }
}
