package com.school.School.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_category")

public class StudentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "student_category", nullable = false, length = 255)
    private String studentCategory;
    @Column(name = "Description", length = 255)
    private String Description;


    public StudentCategory(String studentCategory, String description) {
        this.studentCategory = studentCategory;
        Description = description;
    }

}
