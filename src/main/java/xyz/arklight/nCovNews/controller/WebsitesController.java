package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.Websites;
import xyz.arklight.nCovNews.service.WebsitesService;

import java.util.List;

@RestController
@RequestMapping("/websites")
public class WebsitesController {

    @Autowired
    WebsitesService websitesService;

    @RequestMapping("list")
    public List<Websites> getWebsitesList(){
        List<Websites> list = websitesService.findAll();
        return list;
    }
}
