package com.greenspace.controller;

import com.greenspace.service.IBookKindService;
import com.greenspace.util.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/bookKind")
@Controller
public class BookKindController extends BaseController {

    @Autowired
    private IBookKindService iBookKindService;

    @ResponseBody
    @GetMapping("/allBookKind")
    @RequiresPermissions("bookKind:getAllBookKind")
    public Object getAllBookKind(){
        return ajaxDoneSuccess("GET成功").put("allBookKind", iBookKindService.getAllBookKind());
    }

    @ResponseBody
    @GetMapping("/allBookKindAndCabinet")
    @RequiresPermissions("bookKind:getAllBookKindAndCabinet")
    public Object getAllBookKindAndCabinet(){
        return ajaxDoneSuccess("GET成功").put("allBookKindAndCabinet", iBookKindService.getAllBookKindAndCabinet());
    }
}
