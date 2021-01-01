package sbb.bidb.projectBase.dto;

import lombok.Data;
import sbb.bidb.projectBase.entity.IssueStatus;
import sbb.bidb.projectBase.entity.User;

import java.util.Date;

@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
    private Long projectId;

}
