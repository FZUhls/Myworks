package com.henry.study.objects;

public abstract class Goods {
    protected String name;
    protected int price;

    @Override
    public abstract String toString();

    public Goods(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
}
