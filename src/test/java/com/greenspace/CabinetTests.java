package com.greenspace;

import com.greenspace.dao.CabinetMapper;
import com.greenspace.model.Cabinet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CabinetTests {

    @Autowired
    private CabinetMapper cabinetMapper;

    @Test
    public void insertCab() {
        int n = 0;
        while(n < 20) {
            Cabinet cabinet = new Cabinet();
            byte b = 100;
            cabinet.setCapacity(b);
            cabinet.setAvailableNumber(b);
            cabinetMapper.insertSelective(cabinet);
            n++;
        }
    }
}
