package uz.zako.trainingmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class Admin extends AbsComEntity {

    private String firstName;

    private String lastName;

    private short age;

    private String email;

    private String phoneNumber;
}
