package com.greenspace.service;

import com.greenspace.model.Book;
import com.greenspace.model.BookKind;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    //放书
    public void putBook(Book book);

    //检查BookId是否存在
    public boolean checkExistId(Long id);

    public Optional<Book> selectById(Long id);

}
