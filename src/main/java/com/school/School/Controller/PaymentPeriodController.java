package com.school.School.Controller;
import com.school.School.Dto.RequestDto.PaymentPeriodRequestDto;
import com.school.School.Dto.ResponseDto.PaymentPeriodResponseDto;
import com.school.School.Service.PaymentPeriodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentperiod")
public class PaymentPeriodController {
    private final PaymentPeriodService paymentPeriodService;
    public PaymentPeriodController(PaymentPeriodService paymentPeriodService) {
        this.paymentPeriodService = paymentPeriodService;
    }
    /** add payment period endpoint **/
    @PostMapping("/add")
    public ResponseEntity<PaymentPeriodResponseDto> addPaymentPeriod(@RequestBody final PaymentPeriodRequestDto paymentPeriodRequestDto) {
            PaymentPeriodResponseDto paymentPeriodResponseDto= paymentPeriodService.addPaymentPeriod(paymentPeriodRequestDto);
            return new ResponseEntity<>(paymentPeriodResponseDto, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<PaymentPeriodResponseDto>> getallPaymentPeriods() {
        List<PaymentPeriodResponseDto> paymentPeriodResponseDtoList = paymentPeriodService.getallPaymentPeriods();
        return new ResponseEntity<>(paymentPeriodResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/get{id}")
    public ResponseEntity<PaymentPeriodResponseDto> getPaymentPeriodById(@PathVariable final Long id) {
        PaymentPeriodResponseDto paymentPeriodResponseDto = paymentPeriodService.getPaymentPeriodById(id);
        return new ResponseEntity<>(paymentPeriodResponseDto,HttpStatus.OK);
    }
    @PutMapping("/update{id}")
    public ResponseEntity<PaymentPeriodResponseDto> updatePaymentPeriod(@PathVariable final Long id, @RequestBody final PaymentPeriodRequestDto paymentPeriodRequestDto) {
        PaymentPeriodResponseDto paymentPeriodResponseDto = paymentPeriodService.updatePaymentPeriod(id, paymentPeriodRequestDto);
        return new ResponseEntity<>(paymentPeriodResponseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delet{id}")
    public ResponseEntity<PaymentPeriodResponseDto> deletePaymentPeriod(@PathVariable final Long id) {
        PaymentPeriodResponseDto paymentPeriodResponseDto = paymentPeriodService.deletePaymentPeriod(id);
        return new ResponseEntity<>(paymentPeriodResponseDto,HttpStatus.OK);
    }
}
