package xyz.arklight.nCovNews.model.bean;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class SiteInfo {

    public static String[] keywordlist = {null,"确诊","输入","新冠","新增","境外"};

    private Long uid;
    private String keyword;
    private String url;
    private double hot_spot_degree;

    public SiteInfo(Long uid, String keyword, String url, double hot_spot_degree) {
        this.uid = uid;
        this.keyword = keyword;
        this.url = url;
        this.hot_spot_degree = hot_spot_degree;
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

    public double getHot_spot_degree() {
        return hot_spot_degree;
    }

    public void setHot_spot_degree(double hot_spot_degree) {
        this.hot_spot_degree = hot_spot_degree;
    }
}
