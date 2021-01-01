package sbb.bidb.projectBase.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import sbb.bidb.projectBase.entity.Issue;


public interface IssueRepository extends JpaRepository<Issue,Long> {
}
