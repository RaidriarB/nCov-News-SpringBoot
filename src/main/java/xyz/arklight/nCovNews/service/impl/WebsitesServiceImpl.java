package xyz.arklight.nCovNews.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.bean.Websites;
import xyz.arklight.nCovNews.model.repo.WebsitesRepository;
import xyz.arklight.nCovNews.service.WebsitesService;

import java.util.List;
@Service
public class WebsitesServiceImpl implements WebsitesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebsitesServiceImpl.class);
    private static final String TITLE = "Websites";

    @Autowired
    private WebsitesRepository repository;

    @Override
    public List<Websites> findAll() {
        return repository.findAll();
    }

    @Override
    public Websites insertByWebsites(Websites websites) {
        LOGGER.info("新增 " + TITLE + websites.toString());
        return repository.save(websites);
    }

    @Override
    public Websites update(Websites websites) {
        LOGGER.info("更新 " + TITLE + websites.toString());
        return repository.save(websites);
    }

    @Override
    public Websites delete(Long uid) {
        Websites websites = repository.findById(uid).get();
        repository.delete(websites);
        LOGGER.info("删除 " + TITLE + websites.toString());
        return websites;
    }

    @Override
    public Websites findByUid(Long uid) {
        LOGGER.info("获取"+TITLE+"ID：" + uid);
        return repository.findById(uid).get();
    }
}
