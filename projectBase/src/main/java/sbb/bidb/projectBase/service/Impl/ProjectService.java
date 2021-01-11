package sbb.bidb.projectBase.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.dto.ProjectDto;
import sbb.bidb.projectBase.entity.Project;
import sbb.bidb.projectBase.repo.ProjectRepository;
import sbb.bidb.projectBase.service.IProjectService;
import sbb.bidb.projectBase.util.TPage;

import java.util.Arrays;
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
        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
        if (projectCheck!= null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project projectDb = projectRepository.save(modelMapper.map(projectDto, Project.class));
        projectDto.setId(projectDb.getId());
        return projectDto;
    }

    @Override
    public ProjectDto update (Long id, ProjectDto project)
    {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
