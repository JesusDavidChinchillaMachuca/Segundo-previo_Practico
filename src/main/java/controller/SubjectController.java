package controller;

import Service.SubjectService;
import entity.Subject;
import entity.SubjectSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(
            @RequestBody Subject subject,
            @RequestParam(required = false) Long teacherId
    ) {
        Subject createdSubject = subjectService.createSubject(subject, teacherId);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(subject);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<Subject> updateSubject(
            @PathVariable Long subjectId,
            @RequestBody Subject subjectDetails
    ) {
        Subject updatedSubject = subjectService.updateSubject(
                subjectId,
                subjectDetails
        );
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Subject>> getSubjectsByTeacher(
            @PathVariable Long teacherId
    ) {
        List<Subject> subjects = subjectService.getSubjectsByTeacher(teacherId);
        return ResponseEntity.ok(subjects);
    }

    @PostMapping("/{subjectId}/schedules")
    public ResponseEntity<SubjectSchedule> assignSubjectToSchedule(
            @PathVariable Long subjectId,
            @RequestBody SubjectSchedule scheduleDetails
    ) {
        SubjectSchedule newSchedule = subjectService.assignSubjectToSchedule(
                subjectId,
                scheduleDetails.getDayOfWeek(),
                scheduleDetails.getStartTime(),
                scheduleDetails.getEndTime()
        );
        return new ResponseEntity<>(newSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/{subjectId}/schedules")
    public ResponseEntity<List<SubjectSchedule>> getSubjectSchedule(
            @PathVariable Long subjectId
    ) {
        List<SubjectSchedule> schedules = subjectService.getSubjectSchedule(
                subjectId
        );
        return ResponseEntity.ok(schedules);
    }

    @PutMapping("/schedules/{subjectScheduleId}")
    public ResponseEntity<SubjectSchedule> updateSubjectSchedule(
            @PathVariable Long subjectScheduleId,
            @RequestBody SubjectSchedule scheduleDetails
    ) {
        SubjectSchedule updatedSchedule = subjectService.updateSubjectSchedule(
                subjectScheduleId,
                scheduleDetails
        );
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/schedules/{subjectScheduleId}")
    public ResponseEntity<Void> removeSubjectSchedule(
            @PathVariable Long subjectScheduleId
    ) {
        subjectService.removeSubjectSchedule(subjectScheduleId);
        return ResponseEntity.noContent().build();
    }
}
