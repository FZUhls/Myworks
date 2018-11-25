package com.henry.study.objects;
import com.henry.study.exceptions.GoodsOutofDateException;
import com.henry.study.exceptions.NoGoodsExcepton;
import com.henry.study.objects.interfaces.IStore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XiaoMingStore implements IStore {

    //小明的店有存放不同商品的两个数组表
    private List<Food> foodlist = new ArrayList<>();
    private List<Book> bookslist = new ArrayList<>();

    //在这里实现对私有方法add的重载
    private void add(Book book) {
        bookslist.add(book);
    }
    private void add(Food food) {
        foodlist.add(food);
    }

    //AddGood 方法 用instanceof 判断参数goods的类型，从而向下转型，然后调用重载函数add
    public void AddGood(Goods goods) {
        if (goods instanceof Food) {
            Food food = (Food) goods;
            add(food);
            System.out.println("入库成功");
        } else if (goods instanceof Book) {
            Book book = (Book) goods;
            add(book);
            System.out.println("入库成功");
        }
        else {//在工厂中输入错误会创建为空的Goods对象，在这里不做入表处理，输出语句告知用户输入有误
            System.out.println("工厂送来了不知名商品入库失败。");
        }
    }
    //根据出售不同种类物品来调用不同的Sell方法
    public void SellGoods(String name,String type) {
        switch (type){
            case "Book":
                try {
                    book_Sell(name);
                }catch (NoGoodsExcepton E){
                    System.out.println(E);
                }
                break;
            case "Food":
                try {
                    food_Sell(name);
                }catch (NoGoodsExcepton E){
                    System.out.println(E);
                }catch (GoodsOutofDateException E){
                    System.out.println(E);
                }catch (ParseException F){
                    System.out.println(F);
                }
                break;
            default:
                //在用户输入错误后，给与告知
                System.out.println("抱歉，本店没卖这种商品。");
        }
    }

    //出售方法需要抛出异常，至多三种异常。故定义了三种自定义的异常类。
    private void book_Sell(String name) throws NoGoodsExcepton {
        if (bookslist.size()==0){
            throw new NoGoodsExcepton("我们一本书也没了");
        }
        for(int i=0;i<this.bookslist.size();i++){
            if(this.bookslist.get(i).getName().equals(name)){
                System.out.println(this.bookslist.get(i));
                System.out.println("购买成功，欢迎下次光临");
                this.bookslist.remove(i);
                break;
            }
            if(i == this.bookslist.size()-1){
                throw new NoGoodsExcepton("我们没这本书了。");
            }
        }
    }

    private void food_Sell(String name) throws NoGoodsExcepton,GoodsOutofDateException, ParseException {
        boolean overdue = false;
        /*利用SimpleDateFormat类来格式化系统时间和我们输入的时间，
        * 因为有效期最多精确到日，所以只需要格式化某年某月某天就行了*/
        SimpleDateFormat aday = new SimpleDateFormat("yyyy-MM-dd");
        if (foodlist.size()==0){
            throw new NoGoodsExcepton("我们一点食物也没了");
        }
        for(int i=0;i<foodlist.size();i++){
            if(this.foodlist.get(i).getName().equals(name)){
                Date deadday = aday.parse(this.foodlist.get(i).getDead_line());//找到同名对象后，开始比较有效期
                Date now = aday.parse(aday.format(new Date()));//获取系统时间并且格式化为我们制定的格式化类型
                if(deadday.compareTo(now) >=0){ //只要是有效期在今天或今天之后，都算能吃的
                    System.out.println(this.foodlist.get(i).toString());
                    System.out.println("购买成功，欢迎下次光临");
                    foodlist.remove(i);
                    break;
                }
                else if(deadday.compareTo(now) <0) { //判断过期后，给overdue变量赋值为true
                     overdue = true;
                }
            }
            //当 i = size-1 时，则以遍历完表中的所有对象而没有找到符合对象，需通过if判断抛出何种异常
            if(i == this.foodlist.size()-1 && !overdue){
                throw new NoGoodsExcepton("我们没有这种食物了");
            }
            else if(i == this.foodlist.size()-1 && overdue){
                throw new GoodsOutofDateException("这个食物我们有，但是过期了");
            }
        }
    }
    //小明的店有一个给客人观看菜单的静态方法
    public void Menu(){
        System.out.println("系统菜单：");
        System.out.println("观看菜单请输入1");
        System.out.println("商品采购并入库请输入2");
        System.out.println("顾客需要购买请输入3");
        System.out.println("退出系统请输入4");
    }
}