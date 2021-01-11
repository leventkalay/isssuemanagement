package sbb.bidb.projectBase.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sbb.bidb.projectBase.dto.IssueDetailDto;
import sbb.bidb.projectBase.dto.IssueDto;
import sbb.bidb.projectBase.dto.IssueHistoryDto;
import sbb.bidb.projectBase.dto.IssueUpdateDto;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.entity.User;
import sbb.bidb.projectBase.repo.IssueRepository;
import sbb.bidb.projectBase.repo.ProjectRepository;
import sbb.bidb.projectBase.repo.UserRepository;
import sbb.bidb.projectBase.service.IIssueService;
import sbb.bidb.projectBase.util.TPage;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueService implements IIssueService {
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final IssueHistoryService issueHistoryService;
    private final ModelMapper modelMapper;

    public IssueService(IssueRepository issueRepository, ProjectRepository projectRepository, UserRepository userRepository, IssueHistoryService issueHistoryService, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
        this.issueHistoryService = issueHistoryService;
        this.userRepository =userRepository;
        this.projectRepository=projectRepository;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null)
        {
            throw new IllegalArgumentException("Date cannot be null");
        }
      Issue issueDb=  modelMapper.map(issue, Issue.class);
         issueDb = issueRepository.save(issueDb);
         return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issueDb=issueRepository.getOne(id);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable  pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<IssueDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return response;
    }

    @Transactional
    public IssueDetailDto getByIdWithDetails(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
        List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
        detailDto.setIssueHistories(issueHistoryDtos);
        return detailDto;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }

    @Transactional
    public IssueDetailDto update(Long id, IssueUpdateDto issue) {
        Issue issueDb = issueRepository.getOne(id);
        User user = userRepository.getOne(issue.getAssignee_id());
        issueHistoryService.addHistory(id,issueDb);

        issueDb.setAssignee(user);
        issueDb.setDate(issue.getDate());
        issueDb.setDescription(issue.getDescription());
        issueDb.setDetails(issue.getDetails());
        issueDb.setIssueStatus(issue.getIssueStatus());
        issueDb.setProject(projectRepository.getOne(issue.getProject_id()));
        issueRepository.save(issueDb);
        return getByIdWithDetails(id);
    }


}
