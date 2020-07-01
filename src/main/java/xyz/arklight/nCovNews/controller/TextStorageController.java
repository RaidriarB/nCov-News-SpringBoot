package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.TextStorage;
import xyz.arklight.nCovNews.service.TextStorageService;

import javax.validation.Valid;
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

}
