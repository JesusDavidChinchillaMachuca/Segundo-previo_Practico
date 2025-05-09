package entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<StudentEnrollment> students = new ArrayList<>();

    // @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<SubjectSchedule> schedules = new ArrayList<>();

    // @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Evaluation> evaluations = new ArrayList<>();
}