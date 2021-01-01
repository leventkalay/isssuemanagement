package sbb.bidb.projectBase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sbb.bidb.projectBase.dto.IssueDto;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.util.TPage;

public interface IIssueService {
    IssueDto save (IssueDto issue);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable (Pageable pageable);
}
