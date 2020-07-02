package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.arklight.nCovNews.model.DAO.StatStorage;
import xyz.arklight.nCovNews.model.bean.StatViewResult;
import xyz.arklight.nCovNews.service.StatStorageService;

import java.io.IOException;

@Controller
@RequestMapping(path = "/res")
public class ResourceController {

    @Autowired
    StatStorageService service;

    @RequestMapping(value = "/wordcloud",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public byte[] getWordcloudJson() throws IOException {
        try{
            StatStorage storage = service.getStatStorageList().get(0);
            byte[] result = new StatViewResult(storage).getWordCloud();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/cluster",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getClusterImage() throws IOException {
        try{
            StatStorage storage = service.getStatStorageList().get(0);
            byte[] result = new StatViewResult(storage).getClusterGraph();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
