package uz.zako.trainingmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;
import uz.zako.trainingmanagementsystem.entity.group.Group;
import uz.zako.trainingmanagementsystem.entity.payment.Payment;
import uz.zako.trainingmanagementsystem.payload.paymentPayload.PaymentPayload;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "student")
public class Student extends AbsComEntity {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;

    @OneToOne
    private Group group;

    @OneToOne
    @Cascade(value = CascadeType.ALL)
    private Payment payment;



}
