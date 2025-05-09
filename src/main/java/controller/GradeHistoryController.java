package controller;

import Service.GradeHistoryService;
import Service.GradeService;
import entity.Grade;
import entity.GradeHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades/history")
@RequiredArgsConstructor
public class GradeHistoryController {

    private final GradeHistoryService gradeHistoryService;

    @GetMapping("/{gradeId}")
    public ResponseEntity<List<GradeHistory>> getHistory(@PathVariable Long gradeId) {
        return ResponseEntity.ok(gradeHistoryService.findByGrade(gradeId));
    }
    @PostMapping
    public ResponseEntity<Grade> create(@RequestBody Grade grade,
                                        @RequestParam(defaultValue = "System") String changedBy) {
        return ResponseEntity.ok(GradeService.save(grade, changedBy));
    }
}
