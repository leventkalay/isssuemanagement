package sbb.bidb.projectBase.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectCode;
    private Long managerId;
    private UserDto manager;
}
