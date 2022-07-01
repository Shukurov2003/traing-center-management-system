package uz.zako.trainingmanagementsystem.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;
import uz.zako.trainingmanagementsystem.entity.Student;
import uz.zako.trainingmanagementsystem.entity.payment.PaymentType.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment extends AbsComEntity {

    private BigDecimal payment ;

    private BigDecimal paidMeasure;

    private BigDecimal unpaidMeasure;

    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @OneToMany
    private List<Student> students;

    private Date beginsDate;

    private Date finishDate;



}
