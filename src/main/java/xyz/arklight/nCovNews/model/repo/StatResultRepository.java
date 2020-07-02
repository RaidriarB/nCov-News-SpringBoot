package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.arklight.nCovNews.model.DAO.StatResult;

public interface StatResultRepository extends JpaRepository<StatResult,Long> {
}
