package Service;

import entity.Grade;
import entity.GradeHistory;
import lombok.RequiredArgsConstructor;
import repository.GradeHistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeHistoryService {

    private final GradeHistoryRepository historyRepository;

    public GradeHistory saveHistory(Grade grade, Double oldValue, Double newValue, String user) {
        GradeHistory history = new GradeHistory();
        history.setGrade(grade);
        history.setOldValue(oldValue);
        history.setNewValue(newValue);
        history.setChangedBy(user);
        history.setChangeDate(LocalDateTime.now());
        return historyRepository.save(history);
    }

    public List<GradeHistory> findByGrade(Long gradeId) {
        return historyRepository.findByGradeId(gradeId);
    }
}