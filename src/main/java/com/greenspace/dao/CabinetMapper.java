package com.greenspace.dao;

import com.greenspace.model.Cabinet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CabinetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cabinet record);

    int insertSelective(Cabinet record);

    Cabinet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cabinet record);

    int updateByPrimaryKey(Cabinet record);
}