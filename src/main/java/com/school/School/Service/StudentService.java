package com.school.School.Service;

import com.school.School.Dto.RequestDto.StudentRequestDto;
import com.school.School.Dto.ResponseDto.StudentResponseDto;
import com.school.School.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentResponseDto  addStudent(StudentRequestDto studentRequestDto);
    public List<StudentResponseDto> getallStudents();
    public Student getStudent(Long student_id);
    public StudentResponseDto getStudentById(Long student_id);
    public  StudentResponseDto updateStudent(Long student_id, StudentRequestDto studentRequestDto);
    public StudentResponseDto deleteStudent(Long  student_id);

}
