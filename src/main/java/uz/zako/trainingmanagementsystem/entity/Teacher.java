package uz.zako.trainingmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;
import uz.zako.trainingmanagementsystem.entity.group.Group;
import uz.zako.trainingmanagementsystem.entity.payment.Salary;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "teacher")
public class Teacher extends AbsComEntity {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;

    @OneToMany
    private List<Group> groups;

    @OneToOne
    private Salary salary;
}
