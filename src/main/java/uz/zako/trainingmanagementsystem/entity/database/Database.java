package uz.zako.trainingmanagementsystem.entity.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "database")
public class Database extends AbsComEntity {

    private BigDecimal allPayment;

    private int numberOfStudents;

    private int numberOfPaidStudents;

    private int numberOfUnpaidStudents;

    private int numberOfTeachers;

    private int numberOfAdmin;

    public Database(BigDecimal paidMeasure){
        this.allPayment =paidMeasure;
    }
    public Database(int numberOfStudents){
        this.numberOfStudents = numberOfStudents;
    }
}
