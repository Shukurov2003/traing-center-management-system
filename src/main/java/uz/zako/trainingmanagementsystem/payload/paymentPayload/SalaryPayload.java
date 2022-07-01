package uz.zako.trainingmanagementsystem.payload.paymentPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaryPayload {

    private BigDecimal salary = BigDecimal.ZERO;
    private BigDecimal leftSalary = BigDecimal.ZERO;
    private BigDecimal givenSalary = BigDecimal.ZERO;
}
