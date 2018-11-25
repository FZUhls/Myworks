package com.henry.study.factories;
import com.henry.study.objects.Book;
import com.henry.study.objects.Food;
import com.henry.study.objects.Goods;

import java.util.Scanner;
public class Factory {
    private String name,dead_line;
    private int piece,pages;
    private Scanner scan = new Scanner(System.in);
    //工厂的生产方法通过传入参数，决定进行何种生产操作。
    public Goods Creater(String type){
        switch (type){
            case "Food" :
                System.out.println("请输入需求食物的名称,结束按回车键");
                this.name = scan.next();
                System.out.println("请输入需求食物的零售价,结束按回车键");
                this.piece = scan.nextInt();
                System.out.println("请输入需求食物的保质期格式为XXXX-XX-XX,结束按回车键");
                this.dead_line = scan.next();
                return new Food(name,piece,dead_line);
            case "Book" :
                System.out.println("请输入需求书的名字,结束按回车键");
                this.name = scan.next();
                System.out.println("请输入需求书的零售价，结束按回车键");
                this.piece = scan.nextInt();
                System.out.println("请输入需求书的页数");
                this.pages = scan.nextInt();
                return new Book(name,piece,pages);
            default:
                break;
        }
        return null;
    }
}
