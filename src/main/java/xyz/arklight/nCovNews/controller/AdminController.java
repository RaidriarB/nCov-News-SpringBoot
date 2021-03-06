package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.arklight.nCovNews.model.DAO.TextStorage;
import xyz.arklight.nCovNews.service.TextStorageService;

/**
 * admin路由的Controller
 * 用于查看爬取的文档信息
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TextStorageService textStorageService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTextStorageList(ModelMap map){
        map.addAttribute("TextStorageList",textStorageService.findAll());//这个是传入view的变量的名字
        return "TextStorageList";//这个是View的文件名

    }

    @RequestMapping(method = RequestMethod.GET,path = "/{uid}")
    public String getTextStorage(@PathVariable Long uid , ModelMap map){
        System.out.println("UID:"+uid);
        TextStorage st = textStorageService.findByUid(uid);
        System.out.println(st);
        map.addAttribute("TextStorage",st);
        return "TextStorageView";
    }

}
