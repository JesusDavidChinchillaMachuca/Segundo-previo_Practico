package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double oldValue;
    private Double newValue;

    private LocalDateTime changeDate;

    private String changedBy;

    @ManyToOne
    private Grade grade;
}