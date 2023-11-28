package com.school.School.Dto;
import com.school.School.Dto.ResponseDto.*;
import com.school.School.Model.*;
import java.util.ArrayList;
import java.util.List;

public class mapper {
    /** mapping  add Student **/
    public static StudentResponseDto studentToStudentResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setStudentID(student.getStudentID());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setSecondName(student.getSecondName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setGrade(student.getGrade());
        studentResponseDto.setSection(student.getSection());
        studentResponseDto.setId(student.getId());
        studentResponseDto.setPhoneNumber(student.getPhoneNumber());
        /** List Student Category **/
        List<String> names = new ArrayList<>();
        List<StudentCategory> studentCategories = student.getStudentCategory();
        for (StudentCategory studentCategory: studentCategories) {
            names.add(studentCategory.getStudentCategory());
        }
        studentResponseDto.setStudentCategoryName(names);
        return studentResponseDto;
    }
    /** mapping List Student **/
    public static List<StudentResponseDto>  studentToStudentResponseDto(List<Student> students) {
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        for (Student student: students) {
            studentResponseDtos.add(studentToStudentResponseDto(student));
        }
        return studentResponseDtos;
    }
    /** mapping StudentCategory **/
    public static StudentCategoryResponseDto  studentCategoryToStudentCategoryResponseDto(StudentCategory studentCategory){
        StudentCategoryResponseDto studentCategoryResponseDto = new StudentCategoryResponseDto();
        studentCategoryResponseDto.setStudentCategory(studentCategory.getStudentCategory());
        studentCategoryResponseDto.setDescription(studentCategory.getDescription());
        studentCategoryResponseDto.setId(studentCategory.getId());
        return studentCategoryResponseDto;
    }
    /** mapping list of studentCategory **/
    public static List<StudentCategoryResponseDto> studentCategoryToStudentCategoryResponseDto(List<StudentCategory> studentCategories){
        List<StudentCategoryResponseDto> studentCategoryResponseDtoList = new ArrayList<>();
        for(StudentCategory studentCategory: studentCategories) {
            studentCategoryResponseDtoList.add(studentCategoryToStudentCategoryResponseDto(studentCategory));
        }
        return studentCategoryResponseDtoList;
    }
    /**Mapping Payment Category from model **/
    public static PaymentCategoryResponseDto paymentCategoryToPaymentCategoryResponseDto(PaymentCategory paymentCategory) {
        PaymentCategoryResponseDto paymentCategoryResponseDto = new PaymentCategoryResponseDto();
        paymentCategoryResponseDto.setPaymentCategorieName(paymentCategory.getPaymentCategories());
        paymentCategoryResponseDto.setDescription(paymentCategory.getDescription());
        paymentCategoryResponseDto.setId(paymentCategory.getId());
        /** List Acadmic Year **/
        List<Long> year = new ArrayList<>();
        List<AcademicYear> academicYears = paymentCategory.getAcademicYears();
        for(AcademicYear academicYear: academicYears) {
            year.add(academicYear.getAcademicYear());
        }
        paymentCategoryResponseDto.setAcademicYear(year);
        return paymentCategoryResponseDto;
    }
    /** mapping list PaymentCategory from model **/
    public static List<PaymentCategoryResponseDto> paymentCategoryToPaymentCategoryResponseDto(List<PaymentCategory> paymentCategories) {
        List<PaymentCategoryResponseDto> paymentCategoryResponseDtoList = new ArrayList<>();
        for (PaymentCategory paymentCategory: paymentCategories) {
            paymentCategoryResponseDtoList.add(paymentCategoryToPaymentCategoryResponseDto(paymentCategory));
        }
        return paymentCategoryResponseDtoList;
    }
    /** mapping Acadmic year from model **/
    public static AcademicYearResponseDto  academicYearToAcademicYearResponseDto(AcademicYear academicYear) {
        AcademicYearResponseDto academicYearResponseDto = new AcademicYearResponseDto();
        academicYearResponseDto.setAcademicYear(academicYear.getAcademicYear());
        academicYearResponseDto.setDescription(academicYear.getDescription());
        academicYearResponseDto.setId(academicYear.getId());
        return academicYearResponseDto;
    }
    /** list mapping of models **/
    public static List<AcademicYearResponseDto> academicYearToAcademicYearResponseDto(List<AcademicYear> academicYears) {
        List<AcademicYearResponseDto> academicYearResponseDtoList = new ArrayList<>();
        for (AcademicYear academicYear: academicYears) {
            academicYearResponseDtoList.add(academicYearToAcademicYearResponseDto(academicYear));
        }
        return academicYearResponseDtoList;
    }
    /** mapping PaymentPeriod from model **/
    public static PaymentPeriodResponseDto paymentperiodToPaymentPeriodResponseDto(PaymentPeriod paymentPeriod) {
        PaymentPeriodResponseDto paymentPeriodResponseDto = new PaymentPeriodResponseDto();
        paymentPeriodResponseDto.setPeriod(paymentPeriod.getPeriod());
        paymentPeriodResponseDto.setDescription(paymentPeriod.getDescription());
         paymentPeriodResponseDto.setEndDate(paymentPeriod.getEndDate());
         paymentPeriodResponseDto.setStartDate(paymentPeriod.getStartDate());
          paymentPeriodResponseDto.setId(paymentPeriod.getId());
         /** List Acadmic Year **/
         List<Long> years = new ArrayList<>();
         List<AcademicYear> academicYearList = paymentPeriod.getAcademicYears();
         for(AcademicYear academicYear: academicYearList) {
             years.add(academicYear.getAcademicYear());
         }
         paymentPeriodResponseDto.setAcademicYear(years);
         return paymentPeriodResponseDto;
    }

    /** List mapping of payment period **/
    public static List<PaymentPeriodResponseDto>  paymentperiodToPaymentPeriodResponseDto(List<PaymentPeriod> paymentPeriods) {
        List<PaymentPeriodResponseDto> paymentPeriodResponseDtoList = new ArrayList<>();
        for(PaymentPeriod paymentPeriod: paymentPeriods) {
            paymentPeriodResponseDtoList.add(paymentperiodToPaymentPeriodResponseDto(paymentPeriod));
        }
        return paymentPeriodResponseDtoList;
    }
}

