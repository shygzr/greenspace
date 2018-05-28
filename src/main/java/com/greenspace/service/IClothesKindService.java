package com.greenspace.service;

import com.greenspace.model.ClothesKind;

import java.util.List;
import java.util.Map;

public interface IClothesKindService {

    //获得所有的衣服种类
    public List<ClothesKind> getAllClothesKind();

    //获得所有的衣服种类和柜子信息
    public List<ClothesKind> getAllClothesKindAndCabinet();
}
