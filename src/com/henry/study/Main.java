package com.henry.study;
import com.henry.study.factories.Factory;
import com.henry.study.objects.XiaoMingStore;
import com.henry.study.objects.Goods;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Factory goodsfactory = new Factory();//工厂专门用来生产商品，能为小明的杂货铺定制商品
        Scanner scan = new Scanner(System.in);//使用Scanner类来输入
        XiaoMingStore xmStore = new XiaoMingStore();//这是小明的杂货铺
        boolean do_or_break = true;//布尔变量do_or_break来判断循环菜单是否需终止
        String choose ;
        String type;
        String Name;

        System.out.println("欢迎来到小明的杂货铺，本店小本经营，目前只出售Book和Food两种类型商品，输入时请勿输入错误。");
        xmStore.Menu();

        while (do_or_break){
            choose = scan.next();
            switch (choose){
                case "1":
                    xmStore.Menu();
                    break;
                case "2":
                    System.out.println("请输入需要采购的商品类型");
                    type = scan.next();
                    Goods goods = goodsfactory.Creater(type);
                    xmStore.AddGood(goods);
                    xmStore.Menu();
                    break;
                case "3":
                    System.out.println("请输入需要购买的商品类型");
                    type = scan.next();
                    System.out.println("请输入需要购买的商品的名称");
                    Name = scan.next();
                    xmStore.SellGoods(Name,type);
                    xmStore.Menu();
                    break;
                case "4":
                    do_or_break = false;
                    System.out.println("程序结束");
                    break;
                default:
                    System.out.println("错误选项，请重新输入：");
                    break;
            }
        }
    }
}
