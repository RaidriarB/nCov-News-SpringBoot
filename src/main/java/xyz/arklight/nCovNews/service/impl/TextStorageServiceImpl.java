package xyz.arklight.nCovNews.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.DAO.TextStorage;
import xyz.arklight.nCovNews.model.repo.TextStorageRepository;
import xyz.arklight.nCovNews.service.TextStorageService;

import java.util.List;

@Service
public class TextStorageServiceImpl implements TextStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextStorageServiceImpl.class);
    private static final String TITLE = "Text Storage";

    @Autowired
    private TextStorageRepository repository;

    @Override
    public List<TextStorage> findAll() {
        return repository.findAll();
    }

    @Override
    public TextStorage insertByTextStorage(TextStorage textStorage) {
        LOGGER.info("新增 " + TITLE + textStorage.toString());
        return repository.save(textStorage);
    }

    @Override
    public TextStorage update(TextStorage textStorage) {
        LOGGER.info("更新 " + TITLE + textStorage.toString());
        return repository.save(textStorage);
    }

    @Override
    public TextStorage delete(Long uid) {
        TextStorage textStorage = repository.findById(uid).get();
        repository.delete(textStorage);
        LOGGER.info("删除 " + TITLE + textStorage.toString());
        return textStorage;
    }

    @Override
    public TextStorage findByUid(Long uid) {
        LOGGER.info("获取"+TITLE+"ID：" + uid);
        return repository.findById(uid).get();
    }
}

