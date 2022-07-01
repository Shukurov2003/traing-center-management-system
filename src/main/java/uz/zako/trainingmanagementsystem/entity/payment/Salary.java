package uz.zako.trainingmanagementsystem.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "salary")
public class Salary extends AbsComEntity {
    private BigDecimal salary = BigDecimal.ZERO;
    private BigDecimal leftSalary = BigDecimal.ZERO;
    private BigDecimal givenSalary = BigDecimal.ZERO;
}
