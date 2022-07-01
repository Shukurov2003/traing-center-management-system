package uz.zako.trainingmanagementsystem.payload.groupPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import uz.zako.trainingmanagementsystem.payload.StudentPayload;
import uz.zako.trainingmanagementsystem.payload.TeacherPayload;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupPayload {

    private String name;

    private String department;

    @ManyToOne
    private TeacherPayload teacherPayload;

    @OneToMany
    private List<StudentPayload> studentPayloads;

    public GroupPayload(String name,String department){
        this.name = name;
        this.department = department;
    }

}
