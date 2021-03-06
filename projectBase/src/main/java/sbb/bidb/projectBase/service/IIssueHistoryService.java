package sbb.bidb.projectBase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sbb.bidb.projectBase.dto.IssueHistoryDto;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.entity.IssueHistory;
import sbb.bidb.projectBase.util.TPage;

import java.util.List;

public interface IIssueHistoryService {
    IssueHistoryDto save (IssueHistoryDto issueHistoryDto);
    IssueHistoryDto getById(Long id);
    TPage<IssueHistoryDto> getAllPageable (Pageable pageable);
    List<IssueHistoryDto> getByIssueId(Long id);
    void addHistory(Long id, Issue issueDb);
}
