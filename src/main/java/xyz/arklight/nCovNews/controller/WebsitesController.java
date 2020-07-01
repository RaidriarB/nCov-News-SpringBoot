package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.OpResult;
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

    @RequestMapping("add/{name}/{url}")
    public OpResult addWebsites(@PathVariable String name,
                                @PathVariable String url){
        try{
            Websites ws = new Websites();
            ws.setName(name);
            ws.setStart_url(url);
            websitesService.insertByWebsites(ws);
            return OpResult.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return OpResult.FAILURE;
        }
    }
    @RequestMapping("delete/{uid}")
    public OpResult deleteWebsites(@PathVariable Long uid){
        try{
            websitesService.delete(uid);
            return OpResult.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return OpResult.FAILURE;
        }

    }

}
