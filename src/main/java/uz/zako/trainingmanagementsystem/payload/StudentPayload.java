package uz.zako.trainingmanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.payload.paymentPayload.PaymentPayload;

import javax.persistence.OneToOne;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentPayload {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;

    private Long groupId;

    @OneToOne
    private PaymentPayload paymentPayload;

}
