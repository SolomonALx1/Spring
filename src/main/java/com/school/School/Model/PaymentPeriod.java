package com.school.School.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payment_period")
public class PaymentPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Period")
    private String Period;
    @Column(name = "Description")
    private  String Description;
    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "payment_period_academic_year",
           joinColumns = {@JoinColumn(name = "paymentperiod_id")},
           inverseJoinColumns = {@JoinColumn(name = "academic_year_id")}
   )
    private List<AcademicYear> academicYears = new ArrayList<>();

    public PaymentPeriod(String period, String description, LocalDate startDate, LocalDate endDate, List<AcademicYear> academicYears) {
        Period = period;
        Description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.academicYears = academicYears;
    }
}
