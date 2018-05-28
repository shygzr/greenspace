package com.greenspace.controller;

import com.greenspace.service.IClothesKindService;
import com.greenspace.util.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/clothesKind")
@Controller
public class ClothesKindController extends BaseController {

    @Autowired
    private IClothesKindService iClothesKindService;

    @ResponseBody
    @GetMapping("/allClothesKind")
    @RequiresPermissions("clothesKind:getAllClothesKind")
    public Object getAllClothesKind(){
        return ajaxDoneSuccess("GET成功").put("allClothesKind", iClothesKindService.getAllClothesKind());
    }

    @ResponseBody
    @GetMapping("/allClothesKindAndCabinet")
    @RequiresPermissions("clothesKind:getAllClothesKindAndCabinet")
    public Object getAllClothesKindAndCabinet(){
        return ajaxDoneSuccess("GET成功").put("allClothesKindAndRem", iClothesKindService.getAllClothesKindAndCabinet());
    }

}
