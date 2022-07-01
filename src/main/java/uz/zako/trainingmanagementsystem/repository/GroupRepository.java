package uz.zako.trainingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.trainingmanagementsystem.entity.Teacher;
import uz.zako.trainingmanagementsystem.entity.group.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {


    @Query(
            nativeQuery = true,value = "update groups  set teacher=?1 where id =?2"
    )
    Group insertTeacherToGroup(Teacher teacher,Long groupId);
}
