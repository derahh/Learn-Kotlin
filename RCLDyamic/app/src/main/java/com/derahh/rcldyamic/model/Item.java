package com.derahh.rcldyamic.model;

public class Item {

    private String name;
    private int length;

    public Item(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
