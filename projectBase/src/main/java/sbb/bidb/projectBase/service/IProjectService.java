package sbb.bidb.projectBase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.entity.User;

import java.util.List;

public interface IProjectService {
    Project save (Project project);
    Project getById(Long id);
    List<Project> getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Page <Project> getAllPageable (Pageable pageable);
    Boolean delete(Project project);
}
