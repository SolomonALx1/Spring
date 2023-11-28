package com.school.School.Repositary;
import com.school.School.Model.PaymentPeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPeriodRepo extends CrudRepository<PaymentPeriod, Long> {

}
