package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.arklight.nCovNews.model.bean.TextStorage;

public interface TextStorageRepository extends JpaRepository<TextStorage,Long> {

}
