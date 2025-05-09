package Service;

import entity.Subject;
import entity.SubjectSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface SubjectService {
    Subject createSubject(Subject subjectDetails, Long teacherId);
    Subject getSubjectById(Long subjectId);
    List<Subject> getAllSubjects();
    Subject updateSubject(Long subjectId, Subject subjectDetails);
    void deleteSubject(Long subjectId);
    List<Subject> getSubjectsByTeacher(Long teacherId);
    SubjectSchedule assignSubjectToSchedule(
            Long subjectId,
            DayOfWeek day,
            LocalTime startTime,
            LocalTime endTime
    );
    List<SubjectSchedule> getSubjectSchedule(Long subjectId);
    SubjectSchedule updateSubjectSchedule(
            Long subjectScheduleId,
            SubjectSchedule scheduleDetails
    );
    void removeSubjectSchedule(Long subjectScheduleId);


}