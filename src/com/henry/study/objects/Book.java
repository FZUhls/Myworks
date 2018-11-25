package com.henry.study.objects;

public class Book extends Goods {

    private int pages;

    public Book(String name, int price, int pages){
        super(name,price);
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "产品名："+name+"价格："+ price +"元"+"页数："+pages;
    }
}
