package com.school.School.Dto.RequestDto;
import lombok.Data;
import java.util.List;

@Data
public class PaymentCategoryRequestDto {
    private String paymentCategories;
    private String Description;
    private List<Long> academicYearId;
}
