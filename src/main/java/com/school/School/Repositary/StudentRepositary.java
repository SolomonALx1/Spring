package com.school.School.Repositary;
import com.school.School.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepositary extends CrudRepository<Student, Long> {
}
