package com.school.School.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payment_category")
public final class PaymentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "categories")
    private String paymentCategories;
    @Column(name = "description")
    private String Description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "payment_category_academic_year",
            joinColumns = {@JoinColumn(name = "payment_category_id")},
            inverseJoinColumns = {@JoinColumn(name = "academic_year_id")}
    )
    private List<AcademicYear> academicYears = new ArrayList<>();

    public PaymentCategory(String paymentCategories, String description, List<AcademicYear> academicYears) {
        this.paymentCategories = paymentCategories;
        Description = description;
        this.academicYears = academicYears;
    }
}
