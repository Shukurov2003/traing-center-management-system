package uz.zako.trainingmanagementsystem.payload.paymentPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.payment.PaymentType.PaymentType;
import uz.zako.trainingmanagementsystem.payload.StudentPayload;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentPayload {

    private BigDecimal payment = BigDecimal.ZERO;

    private BigDecimal paidMeasure = BigDecimal.ZERO;

    private BigDecimal unpaidMeasure = BigDecimal.ZERO;

    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @OneToMany
    private List<StudentPayload> studentPayloads;




}
