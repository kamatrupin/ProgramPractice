package com.playground.practice.adtest;

// Input stream
// Set True (index)
// SEt false (index)
public class BooleanStream {

    private int size = 10;
    private boolean array[];

    public BooleanStream() {
        array = new boolean[size];
    }

    public BooleanStream(int size) {
        this.size = size;
        array = new boolean[size];
    }

    public void setTrue(int index) {
        array[index] = true;
    }

    public void setFalse(int index) {
        array[index] = false;
    }

    public boolean getValue(int index) {
        return array[index];
    }

    public void setAll(boolean val) {
        for(int i=0; i<array.length; i++) {
            array[i] = val;
        }
    }

    private boolean[] reviseTheSize() {
        boolean[] temp = array;
        array = new boolean[array.length + 10];
        return temp;
    }
}
