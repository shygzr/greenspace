package com.greenspace.service;

import com.greenspace.model.BookKind;

import java.util.List;

public interface IBookKindService {

    //获取所有图书种类
    public List<BookKind> getAllBookKind();

    //获取所有图书种类and柜子信息
    public List<BookKind> getAllBookKindAndCabinet();
}
