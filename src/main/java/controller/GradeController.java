package controller;

import Service.GradeService;
import entity.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> create(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.save(grade, changedBy));
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAll() {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(gradeService.getByStudent(studentId));
    }

    @GetMapping("/evaluation/{evalId}")
    public ResponseEntity<List<Grade>> getByEvaluation(@PathVariable Long evalId) {
        return ResponseEntity.ok(gradeService.getByEvaluation(evalId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gradeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}