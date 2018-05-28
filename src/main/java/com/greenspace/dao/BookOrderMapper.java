package com.greenspace.dao;

import com.greenspace.model.BookOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookOrder record);

    int insertSelective(BookOrder record);

    BookOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookOrder record);

    int updateByPrimaryKey(BookOrder record);
}