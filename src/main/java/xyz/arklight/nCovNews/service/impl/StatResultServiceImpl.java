package xyz.arklight.nCovNews.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.DAO.StatResult;
import xyz.arklight.nCovNews.model.repo.StatResultRepository;
import xyz.arklight.nCovNews.service.StatResultService;

import java.util.List;

@Service
public class StatResultServiceImpl implements StatResultService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatResultServiceImpl.class);
    private static final String TITLE = "Statistics Result";

    @Autowired
    private StatResultRepository repository;

    @Override
    public List<StatResult> findAll() {
        return repository.findAll();
    }

    @Override
    public StatResult insertByStatResult(StatResult statResult) {
        LOGGER.info("新增 " + TITLE + statResult.toString());
        return repository.save(statResult);
    }

    @Override
    public StatResult update(StatResult statResult) {
        LOGGER.info("更新 " + TITLE + statResult.toString());
        return repository.save(statResult);
    }

    @Override
    public StatResult delete(Long uid) {
        StatResult statResult = repository.findById(uid).get();
        repository.delete(statResult);
        LOGGER.info("删除 " + TITLE + statResult.toString());
        return statResult;
    }

    @Override
    public StatResult findByNo(Long no) {
        LOGGER.info("获取"+TITLE+"ID：" + no);
        return repository.findById(no).get();
    }
}
