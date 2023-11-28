package com.school.School.Dto.RequestDto;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class PaymentPeriodRequestDto {

    private String Period;
    private String Description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> academicYearId;
}
