package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.Teacher;
import uz.zako.trainingmanagementsystem.entity.payment.Payment;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query(
            nativeQuery = true,
            value = "select *from teacher t order by t.updated_at desc  limit 1"
    )
    Teacher findCurrentlyAddedTeacher();
}
