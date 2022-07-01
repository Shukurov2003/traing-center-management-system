package uz.zako.trainingmanagementsystem.entity.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.trainingmanagementsystem.entity.AbstractCommonEntity.AbsComEntity;
import uz.zako.trainingmanagementsystem.entity.Student;
import uz.zako.trainingmanagementsystem.entity.Teacher;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "groups")
public class Group extends AbsComEntity {

    private String name;

    private String department;

    @ManyToOne
    private Teacher teacher;

    @OneToMany
    private List<Student> student;

    public Group(String name, String department){
        this.name = name;
        this.department = department;
    }
}
