package sbb.bidb.projectBase.api;


import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbb.bidb.projectBase.dto.ProjectDto;
import sbb.bidb.projectBase.service.IProjectService;
import sbb.bidb.projectBase.util.ApiPaths;
import sbb.bidb.projectBase.util.TPage;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {
    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/pagination")
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
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

   @PutMapping("/{id}")
    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectService.update(id,project));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectService.delete(id));
    }
}
