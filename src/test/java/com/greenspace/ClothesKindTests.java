package com.greenspace;

import com.greenspace.dao.ClothesKindMapper;
import com.greenspace.model.AuthRole;
import com.greenspace.model.ClothesKind;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IClothesKindService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClothesKindTests {

    @Autowired
    private IClothesKindService iClothesKindService;
    @Autowired
    private ClothesKindMapper clothesKindMapper;

    @Test
    public void getAll() {
        List<ClothesKind> res =  iClothesKindService.getAllClothesKind();
        System.out.println(res);
    }

    @Test
    public void getAllAndRem() {
        System.out.println(clothesKindMapper.selectAllAndCabinet());
    }
}
