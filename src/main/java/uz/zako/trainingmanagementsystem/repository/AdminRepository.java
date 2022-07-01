package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
