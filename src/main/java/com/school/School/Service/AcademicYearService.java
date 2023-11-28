package com.school.School.Service;
import com.school.School.Dto.RequestDto.AcademicYearRequestDto;
import com.school.School.Dto.ResponseDto.AcademicYearResponseDto;
import com.school.School.Model.AcademicYear;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcademicYearService {
    public AcademicYearResponseDto  addAcademicYear(AcademicYearRequestDto academicYearRequestDto);
    public List<AcademicYearResponseDto> getallAcademicYear();
    public AcademicYear getAcademicYear(Long academicYearId);
    public AcademicYearResponseDto getAcademicYearById(Long academicYearId);
    public AcademicYearResponseDto updateAcademicYear(Long academicYearId, AcademicYearRequestDto academicYearRequestDto);
    public AcademicYearResponseDto deleteAcademicYear(Long academicYearId);

}
