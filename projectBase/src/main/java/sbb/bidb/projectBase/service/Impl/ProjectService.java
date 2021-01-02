package sbb.bidb.projectBase.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.dto.ProjectDto;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.repo.ProjectRepository;
import sbb.bidb.projectBase.service.IProjectService;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectService(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        if (projectDto.getProjectCode() == null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }
        Project projectDb = projectRepository.save(modelMapper.map(projectDto, Project.class));
        return modelMapper.map(projectDb, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
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
