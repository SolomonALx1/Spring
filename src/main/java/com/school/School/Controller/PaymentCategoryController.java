package com.school.School.Controller;
import com.school.School.Dto.RequestDto.PaymentCategoryRequestDto;
import com.school.School.Dto.ResponseDto.PaymentCategoryResponseDto;
import com.school.School.Service.PaymentCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/paymentCategory")
public class PaymentCategoryController {
    private final PaymentCategoryService paymentCategoryService;
    public PaymentCategoryController(PaymentCategoryService paymentCategoryService) {
        this.paymentCategoryService = paymentCategoryService;
    }
    @PostMapping("/add")
    public ResponseEntity<PaymentCategoryResponseDto>  addPaymentCategory(@RequestBody final PaymentCategoryRequestDto paymentCategoryRequestDto) {
        PaymentCategoryResponseDto paymentCategoryResponseDto = paymentCategoryService.addPaymentCategory(paymentCategoryRequestDto);
        return new ResponseEntity<>(paymentCategoryResponseDto, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<PaymentCategoryResponseDto>>  getallPaymentCategorys() {
        List<PaymentCategoryResponseDto> paymentCategoryResponseDtoList= paymentCategoryService.getallPaymentCategorys();
        return new ResponseEntity<>(paymentCategoryResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/get{id}")
    public ResponseEntity<PaymentCategoryResponseDto>  getpaymentCategorieById(@PathVariable final Long id) {
        PaymentCategoryResponseDto paymentCategoryResponseDto = paymentCategoryService.getpaymentCategorieById(id);
        return new ResponseEntity<>(paymentCategoryResponseDto,HttpStatus.OK);
    }
    @PutMapping("/update{id}")
    public  ResponseEntity<PaymentCategoryResponseDto>  updatePaymentCategory(@PathVariable final  Long id, @RequestBody final  PaymentCategoryRequestDto paymentCategoryRequestDto)  {
        PaymentCategoryResponseDto editpaymentCategoryResponseDto = paymentCategoryService.updatePaymentCategory(id, paymentCategoryRequestDto);
        return new ResponseEntity<>(editpaymentCategoryResponseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<PaymentCategoryResponseDto> deletePaymentCategory(@PathVariable Long id) {
        PaymentCategoryResponseDto paymentCategoryResponseDto = paymentCategoryService.deletePaymentCategory(id);
        return new ResponseEntity<>(paymentCategoryResponseDto,HttpStatus.OK);
    }
}
