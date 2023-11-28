package com.school.School.Service;
import com.school.School.Dto.RequestDto.StudentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.StudentCategoryResponseDto;
import com.school.School.Dto.mapper;
import com.school.School.Model.StudentCategory;
import com.school.School.Repositary.StudentCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentCategoryServiceImpl  implements  StudentCategoryService{
    public StudentCategoryServiceImpl(StudentCategoryRepo studentCategoryRepo) {
        this.studentCategoryRepo = studentCategoryRepo;
    }
    private final StudentCategoryRepo studentCategoryRepo;

    @Override
    /** add studentCategory Service **/
    public StudentCategoryResponseDto addStudentCategory(StudentCategoryRequestDto studentCategoryRequestDto) {
                  StudentCategory studentCategory = new StudentCategory();
                  studentCategory.setStudentCategory(studentCategoryRequestDto.getStudentCategory());
                  studentCategory.setDescription(studentCategoryRequestDto.getDescription());
                  studentCategoryRepo.save(studentCategory);
                  return mapper.studentCategoryToStudentCategoryResponseDto(studentCategory);
    }

    @Override
    /** list all StudentCategories **/
    public List<StudentCategoryResponseDto> getallStudentCategorys() {
       List<StudentCategory> studentCategories = StreamSupport.
               stream(studentCategoryRepo.findAll().spliterator(), false).collect(Collectors.toList());
         return mapper.studentCategoryToStudentCategoryResponseDto(studentCategories);
    }
    @Override
    /** find a single StudentCategory using findById **/
    public StudentCategory getStudentCategory(Long studentCategoryId) {
        return studentCategoryRepo.findById(studentCategoryId).orElseThrow(() ->
                new IllegalArgumentException("could not find category with id: " + studentCategoryId));
    }
    @Override
    public StudentCategoryResponseDto getStudentCategoryById(Long studentCategoryId) {
        StudentCategory studentCategory = getStudentCategory(studentCategoryId);
        return mapper.studentCategoryToStudentCategoryResponseDto(studentCategory);
    }

    @Override
    /** Update StudentCategory using id **/
    public StudentCategoryResponseDto updateStudentCategory(Long studentCategoryId, StudentCategoryRequestDto studentCategoryRequestDto) {
        StudentCategory editstudentCategory = getStudentCategory(studentCategoryId);
          editstudentCategory.setStudentCategory(studentCategoryRequestDto.getStudentCategory());
          editstudentCategory.setDescription(studentCategoryRequestDto.getDescription());
           return mapper.studentCategoryToStudentCategoryResponseDto(editstudentCategory);
    }
    @Override
    /** delete StudentCategory **/
    public StudentCategoryResponseDto deleteStudentCategory(Long studentCategoryId) {
        StudentCategory studentCategory = getStudentCategory(studentCategoryId);
        studentCategoryRepo.delete(studentCategory);
        return mapper.studentCategoryToStudentCategoryResponseDto(studentCategory);

    }
}
