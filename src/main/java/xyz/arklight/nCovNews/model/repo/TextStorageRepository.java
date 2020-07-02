package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.arklight.nCovNews.model.DAO.TextStorage;

import java.util.List;

public interface TextStorageRepository extends JpaRepository<TextStorage,Long> {
    @Query(value = "select t from TextStorage t order by t.publish_time desc")
    List<TextStorage> selectTop();
}
