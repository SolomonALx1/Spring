package com.school.School.Dto.RequestDto;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequestDto {
    private String firstName;
    private String secondName;
    private  String lastName;
    private String grade;
    private String section;
    private  String phoneNumber;
    private String StudentID;
    private List<Long> studentCategoryIds;
}
