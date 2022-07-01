package uz.zako.trainingmanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminPayload {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;
}
