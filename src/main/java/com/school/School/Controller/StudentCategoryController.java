package com.school.School.Controller;


import com.school.School.Dto.RequestDto.StudentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.StudentCategoryResponseDto;
import com.school.School.Service.StudentCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentCategory")
public class StudentCategoryController {
    private final StudentCategoryService studentCategoryService;
    public StudentCategoryController(StudentCategoryService studentCategoryService) {
        this.studentCategoryService = studentCategoryService;
    }
    /** create StudentCategory endpoint **/
    @PostMapping("/add")
    public ResponseEntity<StudentCategoryResponseDto> addStudentCategory(@RequestBody final StudentCategoryRequestDto studentCategoryRequestDto) {
        StudentCategoryResponseDto studentCategoryResponseDto = studentCategoryService.addStudentCategory(studentCategoryRequestDto);
        return new ResponseEntity<>(studentCategoryResponseDto, HttpStatus.OK);
    }
    /** LIST all StudentCategory endpoint **/
    @GetMapping("/getallStudentCategorys")
      public ResponseEntity<List<StudentCategoryResponseDto>> getallStudentCategorys() {
        List<StudentCategoryResponseDto> studentCategoryResponseDtoList = studentCategoryService.getallStudentCategorys();
        return new ResponseEntity<>(studentCategoryResponseDtoList,HttpStatus.OK);
    }
    /** List aSingle StudentCategory endpoint **/
    @GetMapping("/getStudentCategory{id}")
    public ResponseEntity<StudentCategoryResponseDto> getStudentCategoryById(@PathVariable final  Long id) {
        StudentCategoryResponseDto studentCategoryResponseDto = studentCategoryService.getStudentCategoryById(id);
        return new ResponseEntity<>(studentCategoryResponseDto,HttpStatus.OK);
    }
    /**  update StudentCategory endpoint using id **/
    @PutMapping("/update{id}")
    public ResponseEntity<StudentCategoryResponseDto> updateStudentCategory(@PathVariable final Long id, @RequestBody final StudentCategoryRequestDto studentCategoryRequestDto) {
        StudentCategoryResponseDto studentCategoryResponseDto = studentCategoryService.updateStudentCategory(id, studentCategoryRequestDto);
        return new ResponseEntity<>(studentCategoryResponseDto,HttpStatus.OK);
    }
    /**  DELETE StudentCategory endpoint using id **/
    @DeleteMapping("/delete{id}")
    public ResponseEntity<StudentCategoryResponseDto>  deleteStudentCategory(@PathVariable final Long id) {
        StudentCategoryResponseDto studentCategoryResponseDto = studentCategoryService.deleteStudentCategory(id);
        return new ResponseEntity<>(studentCategoryResponseDto,HttpStatus.OK);
    }


}
