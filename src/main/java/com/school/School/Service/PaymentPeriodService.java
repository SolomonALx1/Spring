package com.school.School.Service;
import com.school.School.Dto.RequestDto.PaymentPeriodRequestDto;
import com.school.School.Dto.ResponseDto.PaymentPeriodResponseDto;
import com.school.School.Model.PaymentPeriod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentPeriodService {
    public PaymentPeriodResponseDto  addPaymentPeriod(PaymentPeriodRequestDto paymentPeriodRequestDto);
    public List<PaymentPeriodResponseDto> getallPaymentPeriods();
    public PaymentPeriod getPaymentPeriod(Long  paymentperiodId);
    public PaymentPeriodResponseDto getPaymentPeriodById(Long paymentperiodId);
    public PaymentPeriodResponseDto  updatePaymentPeriod(Long paymentperiodId, PaymentPeriodRequestDto paymentPeriodRequestDto);
    public PaymentPeriodResponseDto  deletePaymentPeriod(Long paymentperiodId);
}
