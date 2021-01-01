package sbb.bidb.projectBase.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.repo.ProjectRepository;
import sbb.bidb.projectBase.service.IProjectService;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Override
    public Project save(Project project) {
        if(project.getProjectCode()== null)
        {
            throw new IllegalArgumentException("Project Code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode) ;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
          projectRepository.delete(project);
          return Boolean.TRUE;
    }
}
