package uz.zako.trainingmanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherPayload {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;

    private List<Long> groupIds;

    private BigDecimal salary;
}
