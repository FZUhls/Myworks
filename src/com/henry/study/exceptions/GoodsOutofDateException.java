package com.henry.study.exceptions;

public class GoodsOutofDateException extends Exception{
    public GoodsOutofDateException(String EorrorMessage){
        super(EorrorMessage);
    }
    @Override
    public String toString() {
        return "购买发生异常，原因是："+this.getMessage();
    }
}
