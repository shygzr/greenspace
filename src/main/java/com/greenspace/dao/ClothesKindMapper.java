package com.greenspace.dao;

import com.greenspace.model.ClothesKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClothesKindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClothesKind record);

    int insertSelective(ClothesKind record);

    ClothesKind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClothesKind record);

    int updateByPrimaryKey(ClothesKind record);

    List<ClothesKind> selectAll();

    List<ClothesKind> selectAllAndCabinet();
}