package sbb.bidb.projectBase.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbb.bidb.projectBase.dto.IssueDetailDto;
import sbb.bidb.projectBase.dto.IssueDto;
import sbb.bidb.projectBase.dto.IssueUpdateDto;
import sbb.bidb.projectBase.entity.IssueStatus;
import sbb.bidb.projectBase.service.Impl.IssueService;
import sbb.bidb.projectBase.util.ApiPaths;
import sbb.bidb.projectBase.util.TPage;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by temelt on 4.02.2019.
 */
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/pagination")
    public ResponseEntity<TPage<IssueDto>> getAllByPagination(Pageable pageable) {
        TPage<IssueDto> data = issueService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issue = issueService.getById(id);
        return ResponseEntity.ok(issue);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<IssueDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
        IssueDetailDto detailDto = issueService.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueService.save(issue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDetailDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueUpdateDto issue) {
        return ResponseEntity.ok(issueService.update(id,issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.delete(id));
    }

    @GetMapping("/statuses")
    public ResponseEntity<List<IssueStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }


}