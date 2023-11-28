package com.school.School.Dto.ResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private Long Id;
    private String firstName;
    private String secondName;
    private  String lastName;
    private String grade;
    private String section;
    private  String phoneNumber;
    private String StudentID;
    private List<String> studentCategoryName;
}
