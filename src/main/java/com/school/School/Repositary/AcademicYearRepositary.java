package com.school.School.Repositary;

import com.school.School.Model.AcademicYear;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicYearRepositary extends CrudRepository<AcademicYear, Long> {
}
