package xyz.arklight.nCovNews.model.bean;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.text.DecimalFormat;

/**
 * 这个类用来聚合统计数据和网页信息
 */
public class SiteInfo {

    //在数据库中的表示为0-4
    public static String[] keywordlist = {"确诊","输入","新冠","新增","境外"};

    private Long uid;
    private String keyword;
    private String url;
    private String hot_spot_degree;
    private String confidence;

    public SiteInfo(Long uid, String keyword, String url, String hot_spot_degree, String confidence) {
        this.uid = uid;
        this.keyword = keyword;
        this.url = url;
        this.hot_spot_degree = hot_spot_degree;
        this.confidence = confidence;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public static void setKeywordlist(String[] keywordlist) {
        SiteInfo.keywordlist = keywordlist;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHot_spot_degree() {
        return hot_spot_degree;
    }

    public void setHot_spot_degree(String hot_spot_degree) {
        this.hot_spot_degree = hot_spot_degree;
    }

    @Override
    public String toString() {
        return "SiteInfo{" +
                "uid=" + uid +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", hot_spot_degree='" + hot_spot_degree + '\'' +
                '}';
    }
}
