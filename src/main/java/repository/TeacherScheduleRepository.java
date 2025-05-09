package repository;

import entity.TeacherSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherScheduleRepository
        extends JpaRepository<TeacherSchedule, Long> {
    List<TeacherSchedule> findByTeacherId(Long teacherId);
    void deleteByTeacherId(Long teacherId);
}