package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.arklight.nCovNews.model.DAO.StatStorage;

import java.util.List;

public interface StatStorageRepository extends JpaRepository<StatStorage,String> {
    @Query(value = "select t from StatStorage t order by t.addtime desc")
    List<StatStorage> findAll();
}
