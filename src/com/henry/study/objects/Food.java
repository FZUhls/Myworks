package com.henry.study.objects;

public class Food extends Goods {

    private String dead_line;

    public Food(String name, int piece, String  dead_line){
        super(name, piece);
        this.dead_line = dead_line;
    }

    @Override
    public String toString() {
        return "产品名："+name+"价格："+ price +"元"+"保质期至："+dead_line;
    }

    public String getDead_line() {
        return dead_line;
    }
}