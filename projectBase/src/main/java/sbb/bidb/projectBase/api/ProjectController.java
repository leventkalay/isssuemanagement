package sbb.bidb.projectBase.api;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbb.bidb.projectBase.dto.ProjectDto;
import sbb.bidb.projectBase.service.Impl.ProjectService;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@Valid @PathVariable(value = "id", required = true) Long id)
    {
        ProjectDto projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);

    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectService.save(project));
    }

   // @PutMapping
    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectService.update(id,project));
    }

}
