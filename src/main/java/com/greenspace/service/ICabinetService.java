package com.greenspace.service;

import com.greenspace.model.Cabinet;

public interface ICabinetService {

    //开启柜子
    public boolean openCabinet(Long cabinetId);

    //关闭柜子
    public boolean closeCabinet(Long cabinetId);
}
