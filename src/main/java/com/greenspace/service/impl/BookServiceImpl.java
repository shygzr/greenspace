package com.greenspace.service.impl;

import com.greenspace.dao.AuthUserMapper;
import com.greenspace.dao.BookMapper;
import com.greenspace.dao.BookOrderMapper;
import com.greenspace.dao.UserMapper;
import com.greenspace.model.AuthUser;
import com.greenspace.model.Book;
import com.greenspace.model.BookOrder;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IBookService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private IAuthUserService iAuthUserService;
    @Autowired
    private BookOrderMapper bookOrderMapper;
    @Autowired
    private AuthUserMapper authUserMapper;

    @Transactional(rollbackFor=Exception.class,readOnly=false)
    @Override
    public void putBook(Book book) {
        //书籍信息
        book.setStatus((byte) 1);
        book.setNumber((byte) 1);
        bookMapper.insertSelective(book);
        Long bookId = book.getId();
        //订单信息
        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        Optional<AuthUser> oAuthUser = iAuthUserService.getUserByUserName(userName);
        if(oAuthUser.isPresent()){
            AuthUser authUser = oAuthUser.get();
            authUser.setBalance(authUser.getBalance().add(book.getPrice()));
            authUserMapper.updateByPrimaryKeySelective(authUser);
            BookOrder bookOrder = new BookOrder();
            bookOrder.setUserId(authUser.getId());
            bookOrder.setBookId(bookId);
            bookOrder.setCabinetId(book.getCabinetId());
            bookOrder.setCreateTime(new Date());
            bookOrder.setStatus((byte) 1);
            System.out.println(bookOrder);
            bookOrderMapper.insertSelective(bookOrder);

        }
    }

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public boolean checkExistId(Long id) {
        if(selectById(id).isPresent()) {
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public Optional<Book> selectById(Long id) {
        return Optional.ofNullable(bookMapper.selectByPrimaryKey(id));
    }
}
