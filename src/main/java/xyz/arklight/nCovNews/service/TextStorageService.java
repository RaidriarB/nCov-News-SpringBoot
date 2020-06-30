package xyz.arklight.nCovNews.service;

import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.bean.TextStorage;

import java.util.List;

public interface TextStorageService {
    List<TextStorage> findAll();

    TextStorage insertByTextStorage(TextStorage textStorage);

    TextStorage update(TextStorage textStorage);

    TextStorage delete(Long uid);

    TextStorage findByUid(Long uid);
}
