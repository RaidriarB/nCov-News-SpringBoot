package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.arklight.nCovNews.model.DAO.TextStorage;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.util.List;

/**
 * 爬取网页的Controller
 * 用于获取爬取的网页列表和详细内容
 */
@RestController
@RequestMapping("/textstorage")
public class TextStorageController {
    @Autowired
    TextStorageService textStorageService;

    /**
     *
     * @return 爬取网页列表
     */
    @RequestMapping("/list")
    public List<TextStorage> getTextStorageList(){
        List<TextStorage> list = textStorageService.findAll();
        return list;
    }

    @RequestMapping("/{uid}")
    public TextStorage getTextStorage(@PathVariable Long uid){
        TextStorage textStorage = textStorageService.findByUid(uid);
        return textStorage;
    }

    @RequestMapping("/top/{num}")
    public List<TextStorage> getTop10(@PathVariable int num){
        try{
            List <TextStorage> result = textStorageService.findTop().subList(0,num);
            return result;
        }catch (Exception e){
            return null;
        }

    }

}
