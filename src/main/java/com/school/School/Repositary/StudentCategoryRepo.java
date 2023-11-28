package com.school.School.Repositary;

import com.school.School.Model.StudentCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCategoryRepo  extends CrudRepository<StudentCategory, Long> {
}
