package com.greenspace.controller;

import com.greenspace.service.ICabinetService;
import com.greenspace.service.impl.ClothesKindServiceImpl;
import com.greenspace.util.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/cabinet")
@Controller
public class CabinetController extends BaseController {

    @Autowired
    private ICabinetService iCabinetService;
    private static Logger logger = LoggerFactory.getLogger(CabinetController.class);
    private Logger logger1;

    @ResponseBody
    @PostMapping("/openCabinet")
    @RequiresPermissions("cabinet:openCabinet")
    public Object openCabinet(@RequestParam Map<String,Object> params){
        Long cabinetId = Long.parseLong(params.get("cabinetId").toString());
        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        iCabinetService.openCabinet(cabinetId);
        logger.info("用户：" + userName + "开启了" + cabinetId + "号柜子");
        return ajaxDoneSuccess("柜子开启成功");
    }

    @ResponseBody
    @PostMapping("/closeCabinet")
    @RequiresPermissions("cabinet:closeCabinet")
    public Object closeCabinet(@RequestParam Map<String,Object> params){
        Long cabinetId = Long.parseLong(params.get("cabinetId").toString());
        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        iCabinetService.closeCabinet(cabinetId);
        logger.info("用户：" + userName + "关闭了" + cabinetId + "号柜子");
        return ajaxDoneSuccess("柜子关闭成功");
    }
}
