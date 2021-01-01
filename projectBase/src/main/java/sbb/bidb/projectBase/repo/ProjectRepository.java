package sbb.bidb.projectBase.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.entity.User;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> getByProjectCode (String ProjectCode);
    List<Project> getByProjectCodeContains (String ProjectCode);
    Page<Project> findAll (Pageable page);
    List<Project> findAllBy (Sort sort);
}
