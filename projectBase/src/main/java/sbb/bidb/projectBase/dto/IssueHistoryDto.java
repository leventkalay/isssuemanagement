package sbb.bidb.projectBase.dto;

import lombok.Data;
import sbb.bidb.projectBase.entity.IssueStatus;

import java.util.Date;

@Data
public class IssueHistoryDto {
    private Long id;
    private IssueDto issue;
    private String description;
    private Date date;
    private IssueStatus issueStatus;
    private String details;
    private UserDto assignee;
}
