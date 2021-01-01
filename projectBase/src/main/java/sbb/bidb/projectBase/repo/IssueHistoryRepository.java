package sbb.bidb.projectBase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sbb.bidb.projectBase.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

}
