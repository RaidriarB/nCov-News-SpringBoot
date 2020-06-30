package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.StatResult;
import xyz.arklight.nCovNews.model.bean.TextStorage;
import xyz.arklight.nCovNews.service.StatResultService;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.util.List;

@RestController
@RequestMapping("/statresult")
public class StatResultController {
    @Autowired
    StatResultService statResultService;

    @RequestMapping("/list")
    public List<StatResult> getStatResultList(){
        List<StatResult> list = statResultService.findAll();
        return list;
    }
}
