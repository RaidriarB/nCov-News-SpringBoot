package xyz.arklight.nCovNews.service;

import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.bean.Websites;

import java.util.List;

public interface WebsitesService {

    List<Websites> findAll();

    Websites insertByWebsites(Websites websites);

    Websites update(Websites websites);

    Websites delete(Long uid);

    Websites findByUid(Long uid);
}
