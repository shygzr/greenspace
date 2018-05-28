package com.greenspace.service.impl;

import com.greenspace.dao.CabinetMapper;
import com.greenspace.model.Cabinet;
import com.greenspace.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CabinetServiceImpl implements ICabinetService{

    @Autowired
    private CabinetMapper cabinetMapper;

    @Transactional(rollbackFor=Exception.class,readOnly=false)
    @Override
    public boolean openCabinet(Long cabinetId) {
        Cabinet cabinet = new Cabinet();
        cabinet.setId(cabinetId);
        cabinet.setStatus((byte) 1);
        //TODO
        //减少余量
        cabinetMapper.updateByPrimaryKeySelective(cabinet);
        return true;
    }

    @Override
    public boolean closeCabinet(Long cabinetId) {
        Cabinet cabinet = new Cabinet();
        cabinet.setId(cabinetId);
        cabinet.setStatus((byte) 0);
        cabinetMapper.updateByPrimaryKeySelective(cabinet);
        return true;
    }
}
