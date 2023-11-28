package com.school.School.Controller;
import com.school.School.Dto.RequestDto.StudentRequestDto;
import com.school.School.Dto.ResponseDto.StudentResponseDto;
import com.school.School.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

// student endpoints
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    /** create student endpoint **/
    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody final StudentRequestDto studentRequestDto) {
        StudentResponseDto studentResponseDto = studentService.addStudent(studentRequestDto);
        return  new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
    }
    /** List all Students endpoint **/
    @GetMapping("/getallStudents")
    public ResponseEntity<List<StudentResponseDto>>   getallStudents() {
        List<StudentResponseDto> studentResponseDtoList = studentService.getallStudents();
        return new ResponseEntity<>(studentResponseDtoList,HttpStatus.OK);
    }
    /** find asingle Student using id **/
    @GetMapping("/getstudent{id}")
    public ResponseEntity<StudentResponseDto>  getStudentById(@PathVariable final Long id) {
        StudentResponseDto studentResponseDto = studentService.getStudentById(id);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }
    /** Update student endpoint using id  **/
    @PutMapping("/updateStudent{id}")
    public ResponseEntity<StudentResponseDto>  updateStudent(@PathVariable final Long id, @RequestBody final  StudentRequestDto studentRequestDto) {
        StudentResponseDto studentResponseDto = studentService.updateStudent(id, studentRequestDto);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
    }
    /** Delete Student endpoint using id **/
    @DeleteMapping("/deleteStudent{id}")
    public ResponseEntity<StudentResponseDto> deleteStudent(@PathVariable final  Long id) {
        StudentResponseDto studentResponseDto = studentService.deleteStudent(id);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }

}
