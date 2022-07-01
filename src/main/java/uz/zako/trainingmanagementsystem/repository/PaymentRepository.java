package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.payment.Payment;

import java.math.BigDecimal;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query(
            nativeQuery = true,
            value = "select *from payment p order by p.updated_at desc limit 1"
    )
    Payment findCurrentlyAddedPayment();

    @Modifying
    @Query(
            nativeQuery = true,
            value = "update payment  set paid_measure=?1,unpaid_measure=?2 where id=?3"
    )
    void insertPaymentToTrainingCenter(BigDecimal paidMeasure,BigDecimal unpaidMeasure,Long id);


}
