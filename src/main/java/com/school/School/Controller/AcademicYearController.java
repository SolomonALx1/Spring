package com.school.School.Controller;


import com.school.School.Dto.RequestDto.AcademicYearRequestDto;
import com.school.School.Dto.ResponseDto.AcademicYearResponseDto;
import com.school.School.Service.AcademicYearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic")
// endpoint acadmic year endpoint
public class AcademicYearController {
    private final AcademicYearService academicYearService;

    public AcademicYearController(AcademicYearService academicYearService) {
        this.academicYearService = academicYearService;
    }
    @PostMapping("/add")
    public ResponseEntity<AcademicYearResponseDto>  addAcademicYear(@RequestBody final AcademicYearRequestDto academicYearRequestDto) {
      AcademicYearResponseDto academicYearResponseDto = academicYearService.addAcademicYear(academicYearRequestDto);
      return new ResponseEntity<>(academicYearResponseDto, HttpStatus.OK);
    }
    @GetMapping("/getallAcademicYears")
    public ResponseEntity<List<AcademicYearResponseDto>> getallAcademicYear() {
       List<AcademicYearResponseDto> academicYearResponseDtoList = academicYearService.getallAcademicYear();
       return new ResponseEntity<>(academicYearResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/getaSingleAcademicYear{id}")
    public ResponseEntity<AcademicYearResponseDto>  getAcademicYearById(@PathVariable final Long id) {
        AcademicYearResponseDto academicYearResponseDto = academicYearService.getAcademicYearById(id);
        return new ResponseEntity<>(academicYearResponseDto,HttpStatus.OK);
    }
    @PutMapping("/update{id}")
    public ResponseEntity<AcademicYearResponseDto> updateAcademicYear(@PathVariable final Long id,@RequestBody final AcademicYearRequestDto academicYearRequestDto) {
        AcademicYearResponseDto academicYearResponseDto= academicYearService.updateAcademicYear(id, academicYearRequestDto);
        return new ResponseEntity<>(academicYearResponseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<AcademicYearResponseDto>  deleteAcademicYear(@PathVariable final Long id) {
        AcademicYearResponseDto academicYearResponseDto = academicYearService.deleteAcademicYear(id);
        return new ResponseEntity<>(academicYearResponseDto,HttpStatus.OK);
    }
}
