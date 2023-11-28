package com.school.School.Dto.ResponseDto;

import lombok.Data;

import java.util.List;

@Data
public class PaymentCategoryResponseDto {
    private Long Id;
    private String paymentCategorieName;
    private String Description;
    private List<Long> academicYear;
}
