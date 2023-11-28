package com.school.School.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", length = 255)
    private String firstName;
    @Column(name = "second_name",length = 255)
    private String secondName;
    @Column(name = "last_name", length = 255)
    private  String lastName;
    @Column(name = "grade", length = 255)
    private String grade;
    @Column(name = "section", length = 255)
    private String section;
    @Column(name = "phone_number", length = 13)
    private  String phoneNumber;
    @Column(name = "student_id",length = 255, unique = true)
    private String StudentID;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_category",
            joinColumns = {@JoinColumn(name = "student_category")},
            inverseJoinColumns = {@JoinColumn(name = "student_category")}
    )
    private List<StudentCategory> studentCategory;

    public Student(String firstName, String secondName, String lastName, String grade, String section, String phoneNumber, String studentID, List<StudentCategory> studentCategory) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.grade = grade;
        this.section = section;
        this.phoneNumber = phoneNumber;
        StudentID = studentID;
        this.studentCategory = studentCategory;
    }
}
