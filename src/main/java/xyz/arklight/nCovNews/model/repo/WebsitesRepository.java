package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.arklight.nCovNews.model.DAO.Websites;

public interface WebsitesRepository extends JpaRepository<Websites,Long> {
}
