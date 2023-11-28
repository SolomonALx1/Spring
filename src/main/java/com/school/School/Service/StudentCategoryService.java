package com.school.School.Service;

import com.school.School.Dto.RequestDto.StudentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.StudentCategoryResponseDto;
import com.school.School.Model.StudentCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCategoryService {

    public StudentCategoryResponseDto addStudentCategory(StudentCategoryRequestDto studentCategoryRequestDto);
    public List<StudentCategoryResponseDto> getallStudentCategorys();
    public StudentCategory getStudentCategory(Long studentCategoryId);
    public StudentCategoryResponseDto getStudentCategoryById(Long studentCategoryId);
    public StudentCategoryResponseDto updateStudentCategory(Long studentCategoryId , StudentCategoryRequestDto studentCategoryRequestDto);
    public  StudentCategoryResponseDto deleteStudentCategory(Long studentCategoryId );

}
