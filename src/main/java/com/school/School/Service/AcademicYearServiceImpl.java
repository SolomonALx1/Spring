package com.school.School.Service;
import com.school.School.Dto.RequestDto.AcademicYearRequestDto;
import com.school.School.Dto.ResponseDto.AcademicYearResponseDto;
import com.school.School.Dto.mapper;
import com.school.School.Model.AcademicYear;
import com.school.School.Repositary.AcademicYearRepositary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AcademicYearServiceImpl  implements  AcademicYearService{
    private final AcademicYearRepositary academicYearRepositary;
    public AcademicYearServiceImpl(AcademicYearRepositary academicYearRepositary) {
        this.academicYearRepositary = academicYearRepositary;
    }
    @Override
    /** add Acadmic Year Service **/
    public AcademicYearResponseDto addAcademicYear(AcademicYearRequestDto academicYearRequestDto) {
      AcademicYear academicYear = new AcademicYear();
      academicYear.setAcademicYear(academicYearRequestDto.getAcademicYear());
      academicYear.setDescription(academicYearRequestDto.getDescription());
      academicYearRepositary.save(academicYear);
      return mapper.academicYearToAcademicYearResponseDto(academicYear);
    }
    @Override
    /** List all recorde acadmic year using findall **/
    public List<AcademicYearResponseDto> getallAcademicYear() {
        List<AcademicYear> academicYearList = StreamSupport
                .stream(academicYearRepositary.findAll().spliterator(), false).collect(Collectors.toList());
        return mapper.academicYearToAcademicYearResponseDto(academicYearList);
    }
    @Override
    public AcademicYear getAcademicYear(Long academicYearId) {
        return academicYearRepositary.findById(academicYearId).orElseThrow(() ->
                new IllegalArgumentException("could not find category with id: " + academicYearId));
    }
    @Override
    /** List a Single acadmic year using id **/
    public AcademicYearResponseDto getAcademicYearById(Long academicYearId) {
        AcademicYear academicYear = getAcademicYear(academicYearId);
        return mapper.academicYearToAcademicYearResponseDto(academicYear);
    }

    @Override
    /** update AcademicYear service using id **/
    public AcademicYearResponseDto updateAcademicYear(Long academicYearId, AcademicYearRequestDto academicYearRequestDto) {
         AcademicYear editacademicYear = getAcademicYear(academicYearId);
         editacademicYear.setAcademicYear(academicYearRequestDto.getAcademicYear());
         editacademicYear.setDescription(academicYearRequestDto.getDescription());
         return mapper.academicYearToAcademicYearResponseDto(editacademicYear);
    }
    @Override
    /** delete academicYear service using id **/
    public AcademicYearResponseDto deleteAcademicYear(Long academicYearId) {
       AcademicYear academicYear = getAcademicYear(academicYearId);
       academicYearRepositary.delete(academicYear);
        return mapper.academicYearToAcademicYearResponseDto(academicYear);
    }
}
