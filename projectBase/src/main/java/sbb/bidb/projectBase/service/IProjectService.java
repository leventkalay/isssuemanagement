package sbb.bidb.projectBase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sbb.bidb.projectBase.dto.ProjectDto;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.entity.User;
import sbb.bidb.projectBase.util.TPage;

import java.util.List;

public interface IProjectService {
    ProjectDto save (ProjectDto projectDto);
    ProjectDto update (Long id, ProjectDto project);
    ProjectDto getById(Long id);
    Project getByProjectCode(String projectCode);
    TPage<ProjectDto> getAllPageable (Pageable pageable);
    Boolean delete(Long id);
}
