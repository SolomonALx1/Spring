package com.school.School.Service;
import com.school.School.Dto.RequestDto.PaymentPeriodRequestDto;
import com.school.School.Dto.ResponseDto.PaymentPeriodResponseDto;
import com.school.School.Dto.mapper;
import com.school.School.Model.AcademicYear;
import com.school.School.Model.PaymentPeriod;
import com.school.School.Model.Student;
import com.school.School.Repositary.PaymentPeriodRepo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentPeriodServiceImp  implements PaymentPeriodService{
    private PaymentPeriodRepo paymentPeriodRepo;
    private final AcademicYearService academicYearService;

    public PaymentPeriodServiceImp(PaymentPeriodRepo paymentPeriodRepo, AcademicYearService academicYearService) {
        this.paymentPeriodRepo = paymentPeriodRepo;
        this.academicYearService = academicYearService;
    }
    @Override
    public PaymentPeriodResponseDto addPaymentPeriod(PaymentPeriodRequestDto paymentPeriodRequestDto) {
       PaymentPeriod paymentPeriod = new PaymentPeriod();
       paymentPeriod.setPeriod(paymentPeriodRequestDto.getPeriod());
       paymentPeriod.setDescription(paymentPeriodRequestDto.getDescription());
       paymentPeriod.setEndDate(paymentPeriodRequestDto.getEndDate());
       paymentPeriod.setStartDate(paymentPeriodRequestDto.getStartDate());
        /** add Acadmic year to payment period **/
          if(paymentPeriodRequestDto.getAcademicYearId().isEmpty()) {
            throw  new IllegalArgumentException("Pls add Acadmic year");
        } else {
            List<AcademicYear> academicYearList = new ArrayList<>();
            for (Long academicYearName: paymentPeriodRequestDto.getAcademicYearId()) {
                AcademicYear academicYear = academicYearService.getAcademicYear(academicYearName);
                    academicYearList.add(academicYear);
            }
            paymentPeriod.setAcademicYears(academicYearList);
        }
        /** finally create payment period service **/
        PaymentPeriod paymentPeriod1 = paymentPeriodRepo.save(paymentPeriod);
        return mapper.paymentperiodToPaymentPeriodResponseDto(paymentPeriod1);
    }
    @Override
    /** List all Payment Period **/
    public List<PaymentPeriodResponseDto> getallPaymentPeriods() {
        List<PaymentPeriod> paymentPeriods = StreamSupport
                .stream(paymentPeriodRepo.findAll().spliterator(), false).collect(Collectors.toList());
        return mapper.paymentperiodToPaymentPeriodResponseDto(paymentPeriods);
    }
    @Override
    /** find aSingle payment period using id **/
    public PaymentPeriod getPaymentPeriod(Long paymentperiodId) {
        PaymentPeriod paymentPeriod = paymentPeriodRepo.findById(paymentperiodId).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + paymentperiodId));
        return  paymentPeriod;
    }
    @Override
    /** find a Single payment period using id **/
    public PaymentPeriodResponseDto getPaymentPeriodById(Long paymentperiodId) {
        PaymentPeriod paymentPeriod= getPaymentPeriod(paymentperiodId);
        return mapper.paymentperiodToPaymentPeriodResponseDto(paymentPeriod);
    }
    @Override
    public PaymentPeriodResponseDto updatePaymentPeriod(Long paymentperiodId, PaymentPeriodRequestDto paymentPeriodRequestDto) {
      PaymentPeriod editpaymentPeriod = getPaymentPeriod(paymentperiodId);
      editpaymentPeriod.setPeriod(paymentPeriodRequestDto.getPeriod());
      editpaymentPeriod.setDescription(paymentPeriodRequestDto.getDescription());
      editpaymentPeriod.setStartDate(paymentPeriodRequestDto.getStartDate());
      editpaymentPeriod.setEndDate(paymentPeriodRequestDto.getEndDate());
        return mapper.paymentperiodToPaymentPeriodResponseDto(editpaymentPeriod);
    }
    @Override
    public PaymentPeriodResponseDto deletePaymentPeriod(Long paymentperiodId) {
        PaymentPeriod paymentPeriod = getPaymentPeriod(paymentperiodId);
        paymentPeriodRepo.delete(paymentPeriod);
        return mapper.paymentperiodToPaymentPeriodResponseDto(paymentPeriod);
    }
}
