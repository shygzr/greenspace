package com.greenspace.dao;

import com.greenspace.model.BookKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookKindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookKind record);

    int insertSelective(BookKind record);

    BookKind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookKind record);

    int updateByPrimaryKey(BookKind record);

    List<BookKind> selectAll();

    List<BookKind> selectAllAndCabinet();
}