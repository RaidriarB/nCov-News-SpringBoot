package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.TextStorage;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.util.List;

@RestController
@RequestMapping("/textstorage")
public class TextStorageController {
    @Autowired
    TextStorageService textStorageService;

    @RequestMapping("/list")
    public List<TextStorage> getTextStorageList(){
        List<TextStorage> list = textStorageService.findAll();
        return list;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getList(ModelMap map){
        map.addAttribute("TextStorageList",textStorageService.findAll());
        return "TextStorageList";
    }

}
