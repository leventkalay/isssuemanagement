package sbb.bidb.projectBase.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.dto.IssueDto;
import sbb.bidb.projectBase.dto.IssueHistoryDto;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.entity.IssueHistory;
import sbb.bidb.projectBase.repo.IssueHistoryRepository;
import sbb.bidb.projectBase.repo.IssueRepository;
import sbb.bidb.projectBase.service.IIssueHistoryService;
import sbb.bidb.projectBase.service.IIssueService;
import sbb.bidb.projectBase.util.TPage;

import java.util.Arrays;

@Service
public class IssueHistoryService implements IIssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    public IssueHistoryService( IssueHistoryRepository issueHistoryRepository,
                                ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistoryDto save(IssueHistoryDto issueHistoryDto) {
        IssueHistory issueHistoryDb=  modelMapper.map(issueHistoryDto, IssueHistory.class);
        issueHistoryDb = issueHistoryRepository.save(issueHistoryDb);
        return modelMapper.map(issueHistoryDb,IssueHistoryDto.class);
    }

    @Override
    public IssueHistoryDto getById(Long id) {
       IssueHistory issueHistoryDb= issueHistoryRepository.getOne(id);
       return modelMapper.map(issueHistoryDb,IssueHistoryDto.class);
    }

    @Override
    public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
        Page<IssueHistory> data = issueHistoryRepository.findAll(pageable);
        TPage<IssueHistoryDto> response = new TPage<IssueHistoryDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueHistoryDto[].class)));
        return response;
    }
}
