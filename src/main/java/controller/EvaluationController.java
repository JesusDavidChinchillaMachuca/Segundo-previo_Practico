package controller;

import Service.EvaluationService;
import entity.Evaluation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Evaluation> create(@RequestBody Evaluation evaluation) {
        return ResponseEntity.ok(evaluationService.save(evaluation));
    }

    @GetMapping
    public ResponseEntity<List<Evaluation>> getAll() {
        return ResponseEntity.ok(evaluationService.findAll());
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<Evaluation>> bySubject(@PathVariable Long subjectId) {
        return ResponseEntity.ok(evaluationService.findBySubject(subjectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        evaluationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}