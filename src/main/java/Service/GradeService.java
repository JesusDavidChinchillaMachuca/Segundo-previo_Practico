package Service;

import entity.Grade;
import lombok.RequiredArgsConstructor;
import repository.GradeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final GradeHistoryService gradeHistoryService;

    public static Grade save(Grade grade, String changedBy) {
        Grade savedGrade;

        // Verificamos si ya existe (es una actualización)
        if (grade.getId() != null) {
            Grade existing = gradeRepository.findById(grade.getId())
                    .orElseThrow(() -> new RuntimeException("Grade not found"));

            if (!existing.getValue().equals(grade.getValue())) {
                // Registrar historial solo si el valor cambia
                gradeHistoryService.saveHistory(existing, existing.getValue(), grade.getValue(), changedBy);
            }

            existing.setValue(grade.getValue());
            existing.setDateAssigned(LocalDateTime.now());
            savedGrade = gradeRepository.save(existing);
        } else {
            grade.setDateAssigned(LocalDateTime.now());
            savedGrade = gradeRepository.save(grade);
        }

        return savedGrade;
    }

    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    public List<Grade> getByStudent(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public List<Grade> getByEvaluation(Long evalId) {
        return gradeRepository.findByEvaluationId(evalId);
    }

    public Optional<Grade> findById(Long id) {
        return gradeRepository.findById(id);
    }

    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }
}
