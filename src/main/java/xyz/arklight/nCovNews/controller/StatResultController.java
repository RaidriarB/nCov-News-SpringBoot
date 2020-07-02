package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.model.bean.SiteInfo;
import xyz.arklight.nCovNews.model.DAO.StatResult;
import xyz.arklight.nCovNews.model.DAO.TextStorage;
import xyz.arklight.nCovNews.model.bean.StatViewResult;
import xyz.arklight.nCovNews.service.StatResultService;
import xyz.arklight.nCovNews.service.StatStorageService;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 统计信息的Controller
 * 返回爬取网页的统计信息相关
 */
@RestController
@RequestMapping("/statresult")
public class StatResultController {
    @Autowired
    StatResultService statResultService;

    @Autowired
    TextStorageService textStorageService;

    @Autowired
    StatStorageService statStorageService;
    /**
     * 获取统计信息的列表
     * @return 统计信息列表
     */
    //@RequestMapping("/list")
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
                        //keyword = SiteInfo.keywordlist[result.getCategory()];
                        StatViewResult svr = new StatViewResult(statStorageService.getStatStorageList().get(0));
                        keyword = svr.getKeywords()[result.getCategory()];
                        System.out.println(result.getCategory()+"，"+keyword);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("该网站数据的catagory字段不合法！应该在0-4之间");
                    }

                    //将热度值乘以10000，再取整，转为字符串
                    double hsd = result.getHot_spot_degree();
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


    /**
     * 获取降序排序的统计信息列表
     * @return 降序的统计信息列表
     */
    @RequestMapping("/list")
    public List<SiteInfo> getSortedStatResultList(){
        List<SiteInfo> list = getStatResultList();
        Collections.sort(list,(s1,s2)->{
            return - ( Integer.parseInt(s1.getHot_spot_degree())
                    - Integer.parseInt(s2.getHot_spot_degree()) );
        });
        return list;
    }
}
