package com.greenspace.service.impl;

import com.greenspace.dao.BookKindMapper;
import com.greenspace.dao.ClothesKindMapper;
import com.greenspace.model.BookKind;
import com.greenspace.model.ClothesKind;
import com.greenspace.service.IBookKindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class BookKindServiceImpl implements IBookKindService {

    @Autowired
    private BookKindMapper bookKindMapper;
    private static Logger logger = LoggerFactory.getLogger(BookKindServiceImpl.class);

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public List<BookKind> getAllBookKind() {
        List<BookKind> res = bookKindMapper.selectAll();
        if(ObjectUtils.isEmpty(res)){
            logger.error("图书种类为空");
            return null;
        } else {
            return res;
        }
    }

    @Override
    public List<BookKind> getAllBookKindAndCabinet() {
        List<BookKind> res = bookKindMapper.selectAllAndCabinet();
        if(ObjectUtils.isEmpty(res)){
            logger.error("图书种类为空");
            return null;
        } else {
            return res;
        }
    }
}
