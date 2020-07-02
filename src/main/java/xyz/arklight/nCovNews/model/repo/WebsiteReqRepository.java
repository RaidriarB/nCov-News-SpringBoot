package xyz.arklight.nCovNews.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.arklight.nCovNews.model.DAO.WebsiteReq;

public interface WebsiteReqRepository extends JpaRepository<WebsiteReq,Long> {
}
