package xyz.arklight.nCovNews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.DAO.WebsiteReq;
import xyz.arklight.nCovNews.model.repo.WebsiteReqRepository;
import xyz.arklight.nCovNews.service.WebsiteReqService;
import xyz.arklight.nCovNews.service.WebsitesService;

import java.util.List;

@Service
public class WebsiteReqServiceImpl implements WebsiteReqService {

    //没写log

    @Autowired
    private WebsiteReqRepository repository;

    @Override
    public List<WebsiteReq> findAll() {
        return repository.findAll();
    }

    @Override
    public WebsiteReq delete(Long uid) {
        WebsiteReq req = repository.findById(uid).get();
        repository.delete(req);
        return req;
    }

    @Override
    public WebsiteReq insertByWebsiteReq(WebsiteReq websiteReq) {
        return repository.save(websiteReq);
    }
}
