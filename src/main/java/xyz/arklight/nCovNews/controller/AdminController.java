package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.arklight.nCovNews.service.TextStorageService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TextStorageService textStorageService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTextStorageList(ModelMap map){
        map.addAttribute("TextStorageList",textStorageService.findAll());
        return "TextStorageList";

    }

    @RequestMapping("/create")
    public String test(){
        return "userForm";
    }
}
