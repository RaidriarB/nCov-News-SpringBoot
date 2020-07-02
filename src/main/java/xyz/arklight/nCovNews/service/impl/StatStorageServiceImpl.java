package xyz.arklight.nCovNews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.arklight.nCovNews.model.DAO.StatStorage;
import xyz.arklight.nCovNews.model.repo.StatStorageRepository;
import xyz.arklight.nCovNews.service.StatStorageService;

import java.util.List;

@Service
public class StatStorageServiceImpl implements StatStorageService {

    @Autowired
    private StatStorageRepository repository;

    @Override
    public List<StatStorage> getStatStorageList() {
        return repository.findAll();
    }
}
