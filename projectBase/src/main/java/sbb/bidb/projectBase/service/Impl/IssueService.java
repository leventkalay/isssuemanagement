package sbb.bidb.projectBase.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.dto.IssueDto;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.repo.IssueRepository;
import sbb.bidb.projectBase.service.IIssueService;
import sbb.bidb.projectBase.util.TPage;

import java.util.Arrays;

@Service
public class IssueService implements IIssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    public IssueService(IssueRepository issueRepository,
                        ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
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
}
