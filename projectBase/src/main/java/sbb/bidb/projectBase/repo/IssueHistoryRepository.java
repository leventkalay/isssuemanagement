package sbb.bidb.projectBase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sbb.bidb.projectBase.entity.IssueHistory;
import java.util.List;
public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
    List<IssueHistory> getByIssueIdOrderById(Long id);
}
