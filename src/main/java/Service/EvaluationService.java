package Service;

import entity.Evaluation;
import lombok.RequiredArgsConstructor;
import repository.EvaluationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    public List<Evaluation> findBySubject(Long subjectId) {
        return evaluationRepository.findBySubjectId(subjectId);
    }

    public void delete(Long id) {
        evaluationRepository.deleteById(id);
    }

    public Optional<Evaluation> findById(Long id) {
        return evaluationRepository.findById(id);
    }
}
