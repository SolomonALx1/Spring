package com.school.School.Service;
import com.school.School.Dto.RequestDto.StudentRequestDto;
import com.school.School.Dto.ResponseDto.StudentResponseDto;
import com.school.School.Dto.mapper;
import com.school.School.Model.Student;
import com.school.School.Model.StudentCategory;
import com.school.School.Repositary.StudentRepositary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl  implements StudentService{
    public StudentServiceImpl(StudentRepositary studentRepositary, StudentCategoryService studentCategoryService) {
        this.studentRepositary = studentRepositary;
        this.studentCategoryService = studentCategoryService;
    }

    private final StudentRepositary studentRepositary;
    private final StudentCategoryService studentCategoryService;

    @Override
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setStudentID(studentRequestDto.getStudentID());
        student.setPhoneNumber(studentRequestDto.getPhoneNumber());
        student.setGrade(studentRequestDto.getGrade());
        student.setSection(studentRequestDto.getSection());
        student.setLastName(studentRequestDto.getLastName());
        student.setSecondName(studentRequestDto.getSecondName());
        student.setFirstName(studentRequestDto.getFirstName());
        /** add studentCategory to student **/
        if(studentRequestDto.getStudentCategoryIds().isEmpty()) {
            throw  new IllegalArgumentException("Pls add Student Category");
        } else {
            List<StudentCategory> studentCategories = new ArrayList<>();
            for (Long studentCategoryId: studentRequestDto.getStudentCategoryIds()) {
                StudentCategory studentCategory = studentCategoryService.getStudentCategory(studentCategoryId);
                studentCategories.add(studentCategory);
            }
            student.setStudentCategory(studentCategories);
        }
        /** finally create student service **/
         Student student1 = studentRepositary.save(student);
        return mapper.studentToStudentResponseDto(student1);
    }

    @Override
    /** find all or list Students**/
    public List<StudentResponseDto> getallStudents() {
        List<Student> students = StreamSupport.
                stream(studentRepositary.findAll().spliterator(), false).collect(Collectors.toList());
        return mapper.studentToStudentResponseDto(students);
    }

    @Override
    public Student getStudent(Long student_id) {
        Student student = studentRepositary.findById(student_id).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + student_id));
        return  student;


    }
/** find aSingle Student using id **/
    @Override
    public StudentResponseDto getStudentById(Long student_id) {
        Student student =getStudent(student_id);
        return mapper.studentToStudentResponseDto(student);
    }

    @Override
    public StudentResponseDto updateStudent(Long student_id, StudentRequestDto studentRequestDto) {
         Student editstudent = getStudent(student_id);
         editstudent.setStudentID(studentRequestDto.getStudentID());
         editstudent.setFirstName(studentRequestDto.getFirstName());
         editstudent.setSecondName(studentRequestDto.getSecondName());
         editstudent.setLastName(studentRequestDto.getLastName());
         editstudent.setGrade(studentRequestDto.getGrade());
         editstudent.setSection(studentRequestDto.getSection());
         editstudent.setPhoneNumber(studentRequestDto.getPhoneNumber());
       /**  if (!studentRequestDto.getStudentCategoryIds().isEmpty()) {
             List<StudentCategory> studentCategories = new ArrayList<>();
             for(Long studentCategoryId: studentRequestDto.getStudentCategoryIds()) {
                 StudentCategory studentCategory = studentCategoryService.getStudentCategoryById(studentCategoryId);
                  studentCategories.add(studentCategory);
             }
             editstudent.setStudentCategory(studentCategories);
         } **/
         return mapper.studentToStudentResponseDto(editstudent);
    }

    @Override
    /** delete student **/
    public StudentResponseDto deleteStudent(Long student_id) {
        Student student = getStudent(student_id);
        studentRepositary.delete(student);
        return mapper.studentToStudentResponseDto(student);
    }
}
