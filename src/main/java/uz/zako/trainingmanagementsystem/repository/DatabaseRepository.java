package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.database.Database;

import javax.xml.crypto.Data;

@Repository
public interface DatabaseRepository extends JpaRepository<Database,Long> {

}
