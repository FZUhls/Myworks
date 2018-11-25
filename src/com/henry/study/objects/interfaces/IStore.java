package com.henry.study.objects.interfaces;

import com.henry.study.objects.Goods;

public interface IStore {

    public void AddGood(Goods good);
    public void SellGoods(String name,String type);
}
