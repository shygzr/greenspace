package com.greenspace;

import com.greenspace.dao.BookOrderMapper;
import com.greenspace.model.BookOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookOrderTests {

    @Autowired
    private BookOrderMapper bookOrderMapper;

    @Test
    public void insert() {
        BookOrder order = new BookOrder();

        order.setUserId(1L);
        order.setBookId(5L);
        order.setCabinetId(26L);
        order.setCreateTime(new Date());
        order.setStatus((byte) 1);
        bookOrderMapper.insertSelective(order);
    }

    @Test
    public void select() {
        BookOrder order = bookOrderMapper.selectByPrimaryKey(1L);
        System.out.println(order);
    }
}
