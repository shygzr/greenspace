package com.greenspace;

import com.greenspace.dao.BookKindMapper;
import com.greenspace.model.BookKind;
import com.greenspace.model.ClothesKind;
import com.greenspace.service.IBookKindService;
import com.greenspace.service.IClothesKindService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookKindTests {

    @Autowired
    private IBookKindService iBookKindService;
    @Autowired
    private BookKindMapper bookKindMapper;

    @Test
    public void getAll() {
        List<BookKind> res =  iBookKindService.getAllBookKind();
        //System.out.println(res);
    }

    @Test
    public void getAllAndRem() {
        System.out.println(bookKindMapper.selectAllAndCabinet());
    }
}
