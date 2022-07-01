package uz.zako.trainingmanagementsystem.service;

import org.springframework.http.ResponseEntity;
import uz.zako.trainingmanagementsystem.entity.Teacher;
import uz.zako.trainingmanagementsystem.entity.group.Group;
import uz.zako.trainingmanagementsystem.payload.StudentPayload;
import uz.zako.trainingmanagementsystem.payload.TeacherPayload;
import uz.zako.trainingmanagementsystem.payload.groupPayload.GroupPayload;

import java.math.BigDecimal;

public interface AdminService {

    ResponseEntity<?> createStudent(StudentPayload studentPayload);
    ResponseEntity<?> updateStudent(Long id, StudentPayload studentPayload);
    void deleteStudent(Long id);
    ResponseEntity<?> findAllStudents();

    ResponseEntity<?> createTeacher(TeacherPayload teacherPayload);
    ResponseEntity<?> updateTeacher(Long id,TeacherPayload teacherPayload);
    void deleteTeacher(Long id);
    ResponseEntity<?> findAllTeachers();

    ResponseEntity<?> addAdmin();
    ResponseEntity<?> updateAdmin();
    void deleteAdmin();
    ResponseEntity<?> findAllAdmins();

    ResponseEntity<?> createGroup(GroupPayload groupPayload);
    ResponseEntity<?> updateGroup(Long id, GroupPayload groupPayload);
    void deleteGroup(Long id);
    ResponseEntity<?> findAllGroups();


    ResponseEntity<?> paymentToTrainingCenter(Long studentId, BigDecimal paidMeasure);

    ResponseEntity<?> paymentToTeacher(Long teacherId, BigDecimal givenSalary);
}
