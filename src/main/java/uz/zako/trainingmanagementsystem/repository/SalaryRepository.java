package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.payment.Salary;

import java.math.BigDecimal;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

    @Query(
            value = "select *from salary s order by s.created_at desc limit 1 ",
            nativeQuery = true
    )
    Salary findCurrentlyCreatedSalary();
    @Modifying
    @Query(
            nativeQuery = true,
            value = "update salary  set given_salary=?1,left_salary=?2 where id=?3"
    )
    void paymentToTeacher(BigDecimal given_salary, BigDecimal left_salary, Long id);
}
