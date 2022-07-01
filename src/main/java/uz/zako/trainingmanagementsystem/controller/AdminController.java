package uz.zako.trainingmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.zako.trainingmanagementsystem.Result.Result;
import uz.zako.trainingmanagementsystem.entity.payment.Salary;
import uz.zako.trainingmanagementsystem.exceptions.BadRequestException;
import uz.zako.trainingmanagementsystem.payload.StudentPayload;
import uz.zako.trainingmanagementsystem.payload.TeacherPayload;
import uz.zako.trainingmanagementsystem.payload.groupPayload.GroupPayload;
import uz.zako.trainingmanagementsystem.payload.paymentPayload.PaymentPayload;
import uz.zako.trainingmanagementsystem.payload.paymentPayload.SalaryPayload;
import uz.zako.trainingmanagementsystem.service.AdminService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    //Creation
    @PostMapping("/group/")
    public ResponseEntity<?> createGroup(@RequestBody GroupPayload groupPayload){
        if(groupPayload==null){
            return ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        return adminService.createGroup(groupPayload);
    }
    @PostMapping("/student/")
    public ResponseEntity<?> createStudent(@RequestBody StudentPayload studentPayload){

        if(studentPayload == null){
            return ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        System.out.println("StudentPayload:"+studentPayload);

        return adminService.createStudent(studentPayload);
    }
    @PostMapping("/teacher/")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherPayload teacherPayload){

        if(teacherPayload==null){
            return ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        return adminService.createTeacher(teacherPayload);
    }
    @PostMapping("/")
    public ResponseEntity<?> createAdmin(){

        return adminService.addAdmin();
    }

    //update
    @PutMapping("/group/{id}/")
    public ResponseEntity<?> updateGroup(@RequestBody GroupPayload groupPayload,@PathVariable Long id){
        if(groupPayload==null){
            return ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        return adminService.updateGroup(id,groupPayload);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentPayload studentPayload){

        if(studentPayload == null){
            return  ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        return adminService.updateStudent(id,studentPayload);
    }

    @PutMapping("/teacher/{id}/")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id,@RequestBody TeacherPayload teacherPayload){
        return adminService.updateTeacher(id,teacherPayload);
    }

    @PutMapping("/admin/")
    public ResponseEntity<?> updateAdmin(){
        return adminService.updateAdmin();
    }

    //deletion

    @DeleteMapping("/group/{id}/")
    public void deleteGroup(@PathVariable Long id){
        adminService.deleteGroup(id);
    }
    @DeleteMapping("/student/{id}/")
    public void deleteStudent(@PathVariable Long id){

        adminService.deleteStudent(id);
    }

    @DeleteMapping("/teacher/{id}/")
    public void deleteTeacher(@PathVariable Long id){

        adminService.deleteTeacher(id);
    }

    @DeleteMapping("/admin/{id}/")
    public void deleteAdmin(@PathVariable Long id){

        adminService.deleteAdmin();
    }

    //to find all

    @GetMapping("/groups/")
    public ResponseEntity<?> findAllGroups(){
        return adminService.findAllGroups();
    }

    @GetMapping("/students/")
    public ResponseEntity<?> findAllStudents(){

        return adminService.findAllStudents();
    }

    @GetMapping("/teachers/")
    public ResponseEntity<?> findAllTeachers(){

        return adminService.findAllTeachers();
    }

    @GetMapping("/admins/")
    public ResponseEntity<?> findAllAdmins(){

        return adminService.findAllAdmins();
    }
    //insertion new one

    @PutMapping("/student/{id}/payment/")
    public ResponseEntity paymentToTrainingCenter(@PathVariable(name = "id") Long id, @RequestBody PaymentPayload paymentPayload){

        if (paymentPayload==null){
            return  ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        BigDecimal paidMeasure = paymentPayload.getPaidMeasure();
        System.out.println("paidMeasure :"+paidMeasure);
        return adminService.paymentToTrainingCenter(id,paidMeasure);
    }
    @PutMapping("/teacher/{id}/paying-salary/")
    public ResponseEntity paymentToTeacher(@PathVariable Long id, @RequestBody SalaryPayload salaryPayload){
        if (salaryPayload == null){
            return  ResponseEntity.badRequest().body(Result.error(HttpStatus.BAD_REQUEST.toString()));
        }
        BigDecimal givenSalary = salaryPayload.getGivenSalary();
        return adminService.paymentToTeacher(id,givenSalary);
    }
}
