package com.greenspace.service.impl;

import com.greenspace.dao.ClothesKindMapper;
import com.greenspace.model.ClothesKind;
import com.greenspace.service.IClothesKindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class ClothesKindServiceImpl implements IClothesKindService {

    @Autowired
    private ClothesKindMapper clothesKindMapper;
    private static Logger logger = LoggerFactory.getLogger(ClothesKindServiceImpl.class);

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public List<ClothesKind> getAllClothesKind() {
        List<ClothesKind> res = clothesKindMapper.selectAll();
        if(ObjectUtils.isEmpty(res)){
            logger.error("衣服种类为空");
            return null;
        } else {
            return res;
        }
    }

    @Override
    public List<ClothesKind> getAllClothesKindAndCabinet() {
        List<ClothesKind> res = clothesKindMapper.selectAllAndCabinet();
        if(ObjectUtils.isEmpty(res)){
            logger.error("衣服种类为空");
            return null;
        } else {
            return res;
        }
    }
}
