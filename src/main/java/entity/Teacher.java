package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {
    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeacherSchedule> availableSchedules = new ArrayList<>();

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UnavailableTime> unavailableTimes = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private List<Subject> subjects = new ArrayList<>();

    public void addAvailableSchedule(TeacherSchedule schedule) {
        availableSchedules.add(schedule);
        schedule.setTeacher(this);
    }

    public void removeAvailableSchedule(TeacherSchedule schedule) {
        availableSchedules.remove(schedule);
        schedule.setTeacher(null);
    }

    public void addUnavailableTime(UnavailableTime unavailableTime) {
        unavailableTimes.add(unavailableTime);
        unavailableTime.setTeacher(this);
    }

    public void removeUnavailableTime(UnavailableTime unavailableTime) {
        unavailableTimes.remove(unavailableTime);
        unavailableTime.setTeacher(null);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        subject.setTeacher(null);
    }
}
