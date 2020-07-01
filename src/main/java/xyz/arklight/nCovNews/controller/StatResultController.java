package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.SiteInfo;
import xyz.arklight.nCovNews.model.bean.StatResult;
import xyz.arklight.nCovNews.model.bean.TextStorage;
import xyz.arklight.nCovNews.service.StatResultService;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statresult")
public class StatResultController {
    @Autowired
    StatResultService statResultService;

    @Autowired
    TextStorageService textStorageService;

    /*
    @RequestMapping("/list")
    public List<StatResult> getStatResultList(){
        List<StatResult> list = statResultService.findAll();
        return list;
    }
    */

    @RequestMapping("/list")
    public List<SiteInfo> getStatResultList() {
        List<StatResult> resultList = statResultService.findAll();
        List<TextStorage> textStorageList = textStorageService.findAll();

        List<SiteInfo> list = new ArrayList<SiteInfo>();

        for (TextStorage textStorage : textStorageList) {
            Long uid = textStorage.getUid();
            String url = textStorage.getUrl();
            String keyword = null;
            String hot_spot_degree = null;
            String confidence = null;


            for (StatResult result : resultList) {
                if (result.getNo().equals(uid)) {
                    try {
                        System.out.println(result.getCategory()+"，"+SiteInfo.keywordlist[result.getCategory()]);
                        keyword = SiteInfo.keywordlist[result.getCategory()];
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("该网站数据的catagory字段不合法！应该在0-4之间");
                    }

                    //将热度值乘以10000，再取整，转为字符串
                    double hsd = result.getHot_spot_degree() * 10000;
                    int hsd_int = (int)hsd;
                    hot_spot_degree = String.valueOf(hsd_int);

                    //可信度转为字符串
                    double cfd = result.getConfidence();
                    confidence = new DecimalFormat("0.000000").format(cfd);

                    break;
                } else {
                    continue;
                }
            }

            SiteInfo info = new SiteInfo(uid, keyword, url, hot_spot_degree,confidence);
            list.add(info);
            System.out.println(info);
        }
        return list;
    }
}
