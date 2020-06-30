package xyz.arklight.nCovNews.service;

import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.bean.StatResult;

import java.util.List;

public interface StatResultService {
    List<StatResult> findAll();

    StatResult insertByStatResult(StatResult statResult);

    StatResult update(StatResult statResult);

    StatResult delete(Long no);

    StatResult findByNo(Long no);
}
