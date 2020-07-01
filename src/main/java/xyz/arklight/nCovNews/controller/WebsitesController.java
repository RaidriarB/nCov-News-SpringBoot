package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.OpResult;
import xyz.arklight.nCovNews.model.bean.Websites;
import xyz.arklight.nCovNews.service.WebsitesService;

import java.util.List;

/**
 * 自定义爬取列表的Controller
 */
@RestController
@RequestMapping("/websites")
public class WebsitesController {

    @Autowired
    WebsitesService websitesService;

    /**
     * 返回爬取网站的列表
     * @return 网站列表
     */
    @RequestMapping("list")
    public List<Websites> getWebsitesList(){
        List<Websites> list = websitesService.findAll();
        return list;
    }

    /**
     * 添加一个爬取的网站
     * @param name 网站名称
     * @param url 网站URL
     * @return 操作是否成功
     */
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

    /**
     * 删除一个爬取的网站
     * @param uid 网站的uid
     * @return 操作是否成功
     */
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
