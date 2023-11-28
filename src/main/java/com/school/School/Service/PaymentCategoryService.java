package com.school.School.Service;
import com.school.School.Dto.RequestDto.PaymentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.PaymentCategoryResponseDto;
import com.school.School.Model.PaymentCategory;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public interface PaymentCategoryService  {
    public PaymentCategoryResponseDto addPaymentCategory(PaymentCategoryRequestDto paymentCategoryRequestDto);
    public List<PaymentCategoryResponseDto>  getallPaymentCategorys();
    public PaymentCategory getpaymentCategorie(Long  paymentCategorieId);
    public PaymentCategoryResponseDto getpaymentCategorieById(Long paymentCategorieId);
   public PaymentCategoryResponseDto  updatePaymentCategory(Long paymentCategorieId, PaymentCategoryRequestDto paymentCategoryRequestDto);
   public PaymentCategoryResponseDto deletePaymentCategory(Long paymentCategorieId);

}
