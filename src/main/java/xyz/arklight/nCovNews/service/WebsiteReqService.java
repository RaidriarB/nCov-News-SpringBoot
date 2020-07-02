package xyz.arklight.nCovNews.service;

import xyz.arklight.nCovNews.model.DAO.WebsiteReq;
import xyz.arklight.nCovNews.model.DAO.Websites;

import java.util.List;

public interface WebsiteReqService {
    List<WebsiteReq> findAll();

    WebsiteReq delete(Long uid);

    WebsiteReq insertByWebsiteReq(WebsiteReq websiteReq);
}
