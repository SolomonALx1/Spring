package com.school.School.Service;
import com.school.School.Dto.RequestDto.PaymentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.PaymentCategoryResponseDto;
import com.school.School.Dto.mapper;
import com.school.School.Model.AcademicYear;
import com.school.School.Model.PaymentCategory;
import com.school.School.Repositary.PaymentCategoryRepositary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentCategoryServiceImp implements PaymentCategoryService{
    private final PaymentCategoryRepositary paymentCategoryRepositary;
    private final AcademicYearService academicYearService;

    public PaymentCategoryServiceImp(PaymentCategoryRepositary paymentCategoryRepositary, AcademicYearService academicYearService) {
        this.paymentCategoryRepositary = paymentCategoryRepositary;
        this.academicYearService = academicYearService;
    }
    @Override
    public PaymentCategoryResponseDto addPaymentCategory(PaymentCategoryRequestDto paymentCategoryRequestDto) {
        PaymentCategory paymentCategory = new PaymentCategory();
        paymentCategory.setPaymentCategories(paymentCategoryRequestDto.getPaymentCategories());
        paymentCategory.setDescription(paymentCategoryRequestDto.getDescription());
        /** add Acadmic year to payment category **/
        if(paymentCategoryRequestDto.getAcademicYearId().isEmpty()) {
            throw  new IllegalArgumentException("Pls add Acadmic year");
        } else {
            List<AcademicYear> academicYearList = new ArrayList<>();
            for (Long academicYearName: paymentCategoryRequestDto.getAcademicYearId()) {
                AcademicYear academicYear = academicYearService.getAcademicYear(academicYearName);
                academicYearList.add(academicYear);
            }
            paymentCategory.setAcademicYears(academicYearList);
        }
        /** finally create payment category service **/
        PaymentCategory paymentCategory1 = paymentCategoryRepositary.save(paymentCategory);
        return mapper.paymentCategoryToPaymentCategoryResponseDto(paymentCategory);
    }
    @Override
    public List<PaymentCategoryResponseDto> getallPaymentCategorys() {
        List<PaymentCategory> paymentCategoryList = StreamSupport
                .stream(paymentCategoryRepositary.findAll().spliterator(), false).collect(Collectors.toList());
        return mapper.paymentCategoryToPaymentCategoryResponseDto(paymentCategoryList);
    }
    @Override
    public PaymentCategory getpaymentCategorie(Long paymentCategorieId) {
        PaymentCategory paymentCategory = paymentCategoryRepositary.findById(paymentCategorieId).orElseThrow(() ->
                new IllegalArgumentException(
                        "payment with id: " + paymentCategorieId + " could not be found"));
        return paymentCategory;
    }
    @Override
    public PaymentCategoryResponseDto getpaymentCategorieById(Long paymentCategorieId) {
        PaymentCategory paymentCategory = getpaymentCategorie(paymentCategorieId);
        return mapper.paymentCategoryToPaymentCategoryResponseDto(paymentCategory);
    }
    @Override
    public PaymentCategoryResponseDto updatePaymentCategory(Long paymentCategorieId, PaymentCategoryRequestDto paymentCategoryRequestDto) {
        PaymentCategory editpaymentCategory = getpaymentCategorie(paymentCategorieId);
        editpaymentCategory.setPaymentCategories(paymentCategoryRequestDto.getPaymentCategories());
        editpaymentCategory.setDescription(paymentCategoryRequestDto.getDescription());
        return mapper.paymentCategoryToPaymentCategoryResponseDto(editpaymentCategory);
    }
    @Override
    public PaymentCategoryResponseDto deletePaymentCategory(Long paymentCategorieId) {
        PaymentCategory paymentCategory = getpaymentCategorie(paymentCategorieId);
        paymentCategoryRepositary.delete(paymentCategory);
        return mapper.paymentCategoryToPaymentCategoryResponseDto(paymentCategory);

    }
}
