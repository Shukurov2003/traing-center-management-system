package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.Student;

import javax.naming.Name;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


}
