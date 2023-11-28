package com.school.School.Dto.ResponseDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class PaymentPeriodResponseDto {
    private Long Id;
    private String Period;
    private String Description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> academicYear;
}
