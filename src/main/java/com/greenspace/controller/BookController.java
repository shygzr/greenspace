package com.greenspace.controller;

import com.greenspace.model.Book;
import com.greenspace.service.IBookKindService;
import com.greenspace.service.IBookService;
import com.greenspace.util.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/book")
@Controller
public class BookController extends BaseController {

    @Autowired
    private IBookService iBookService;

    @ResponseBody
    @PostMapping("/putBook")
    @RequiresPermissions("book:putBook")
    public Object putBook(Book book) {
        iBookService.putBook(book);
        return ajaxDoneSuccess("放书成功");
    }


}
