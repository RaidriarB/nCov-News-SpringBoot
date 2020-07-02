package xyz.arklight.nCovNews.service;

import xyz.arklight.nCovNews.model.DAO.TextStorage;

import java.util.List;

public interface TextStorageService {
    List<TextStorage> findAll();

    TextStorage delete(Long uid);

    TextStorage findByUid(Long uid);

    List<TextStorage> findTop();
}
