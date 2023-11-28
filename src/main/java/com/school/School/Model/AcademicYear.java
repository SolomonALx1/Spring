package com.school.School.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "academicyear")
public class AcademicYear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "academic_year")
    private Long AcademicYear;
    @Column(name = "Description")
    private String Description;

    public AcademicYear(Long academicYear, String description) {
        AcademicYear = academicYear;
        Description = description;
    }
}
