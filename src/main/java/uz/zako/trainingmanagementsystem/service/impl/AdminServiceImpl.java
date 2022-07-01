package uz.zako.trainingmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.trainingmanagementsystem.Result.Result;
import uz.zako.trainingmanagementsystem.entity.Student;
import uz.zako.trainingmanagementsystem.entity.Teacher;
import uz.zako.trainingmanagementsystem.entity.group.Group;
import uz.zako.trainingmanagementsystem.entity.payment.Payment;
import uz.zako.trainingmanagementsystem.entity.payment.Salary;
import uz.zako.trainingmanagementsystem.exceptions.BadRequestException;
import uz.zako.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import uz.zako.trainingmanagementsystem.mapper.PaymentMapper;
import uz.zako.trainingmanagementsystem.mapper.StudentMapper;
import uz.zako.trainingmanagementsystem.payload.StudentPayload;
import uz.zako.trainingmanagementsystem.payload.TeacherPayload;
import uz.zako.trainingmanagementsystem.payload.groupPayload.GroupPayload;
import uz.zako.trainingmanagementsystem.repository.*;
import uz.zako.trainingmanagementsystem.service.AdminService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final PaymentRepository paymentRepository;
    private final StudentMapper studentMapper;
    private final DatabaseRepository databaseRepository;
    private final PaymentMapper paymentMapper;
    private final SalaryRepository salaryRepository;

//  Student
    @Override
    public ResponseEntity<?> createStudent(StudentPayload studentPayload) {


        try{
            Student student = new Student();
            student.setFirstName(studentPayload.getFirstName());
            student.setLastName(studentPayload.getLastName());
            student.setAge(studentPayload.getAge());
            student.setEmail(studentPayload.getEmail());
            student.setPhoneNumber(studentPayload.getPhoneNumber());
            student.setGroup(groupRepository.findById(studentPayload.getGroupId()).orElseThrow(()->new ResourceNotFoundException(HttpStatus.NOT_FOUND.toString())));
            studentPayload.getPaymentPayload().setUnpaidMeasure(studentPayload.getPaymentPayload().getPayment());
            paymentRepository.save(paymentMapper.toEntity(studentPayload.getPaymentPayload()));
            System.out.println("By createdAt: "+paymentRepository.findCurrentlyAddedPayment());
            student.setPayment(paymentRepository.findCurrentlyAddedPayment());
            studentRepository.save(student);
            return ResponseEntity.ok(Result.ok(student,HttpStatus.OK.toString()));
        }catch (BadRequestException e){
           return ResponseEntity.badRequest().body(Result.error(e.getMessage()));

        }
    }

    @Override
    public ResponseEntity<?> updateStudent(Long id,StudentPayload studentPayload) {
        try{
            Student student = new Student();
            student.setId(id);
            student.setFirstName(studentPayload.getFirstName());
            student.setLastName(studentPayload.getLastName());
            student.setAge(studentPayload.getAge());
            student.setEmail(studentPayload.getEmail());
            student.setPhoneNumber(studentPayload.getPhoneNumber());
            student.setGroup(groupRepository.findById(studentPayload.getGroupId()).orElseThrow(()->new ResourceNotFoundException(HttpStatus.NOT_FOUND.toString())));
            Payment payment = paymentMapper.toEntity(studentPayload.getPaymentPayload());
            payment.setId(studentRepository.findById(id).get().getPayment().getId());
            paymentRepository.save(payment);
            student.setPayment(paymentRepository.findCurrentlyAddedPayment());

            studentRepository.save(student);
            return ResponseEntity.ok(Result.ok(student,HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));

        }
    }

    @Override
    public void deleteStudent(Long id) {
        try{
            studentRepository.deleteById(id);
        }catch (ResourceNotFoundException e){
            log.error("group id: "+id);
        }
    }

    @Override
    public ResponseEntity<?> findAllStudents() {

        try{
            return ResponseEntity.ok(Result.ok(studentRepository.findAll(),HttpStatus.OK.toString()));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.internalServerError().body(Result.error(e.getMessage()));

        }
    }


//    Teacher
    @Override
    public ResponseEntity<?> createTeacher(TeacherPayload teacherPayload) {

        try{

            Teacher teacher = new Teacher();
            teacher.setFirstName(teacherPayload.getFirstName());
            teacher.setLastName(teacherPayload.getLastName());
            teacher.setAge(teacherPayload.getAge());
            teacher.setEmail(teacherPayload.getEmail());
            teacher.setPhoneNumber(teacherPayload.getPhoneNumber());
            List<Group> groups = groupRepository.findAllById(teacherPayload.getGroupIds());

            System.out.println("Bu groups"+groups);
            teacher.setGroups(groups);
            Salary salary = new Salary();
            salary.setSalary(teacherPayload.getSalary());
            salary.setLeftSalary(teacherPayload.getSalary());
            salaryRepository.save(salary);
            salary = salaryRepository.findCurrentlyCreatedSalary();
            teacher.setSalary(salary);

            teacherRepository.save(teacher);



            return ResponseEntity.ok(Result.ok(teacherRepository.findCurrentlyAddedTeacher(),HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<?> updateTeacher(Long id,TeacherPayload teacherPayload) {
        try{

            // Buni to'girlash kerak

            Teacher teacher = new Teacher();
            teacher.setFirstName(teacherPayload.getFirstName());
            teacher.setLastName(teacherPayload.getLastName());
            teacher.setAge(teacherPayload.getAge());
            teacher.setEmail(teacherPayload.getEmail());
            teacher.setPhoneNumber(teacherPayload.getPhoneNumber());
            List<Group> groups = groupRepository.findAllById(teacherPayload.getGroupIds());

            System.out.println("Bu groups"+groups);
            teacher.setGroups(groups);
            teacher.getSalary().setSalary(teacherPayload.getSalary());

            teacherRepository.save(teacher);



            return ResponseEntity.ok(Result.ok(teacherRepository.findCurrentlyAddedTeacher(),HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }
    }

    @Override
    public void deleteTeacher(Long id) {

        try{
            teacherRepository.deleteById(id);
        }catch (ResourceNotFoundException e){
            log.error("group id: "+id);
        }
    }

    @Override
    public ResponseEntity<?> findAllTeachers() {

        try{
            return ResponseEntity.ok(Result.ok(teacherRepository.findAll(),HttpStatus.OK.toString()));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.internalServerError().body(Result.error(e.getMessage()));

        }
    }

//    Admin
    @Override
    public ResponseEntity<?> addAdmin() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateAdmin() {
        return null;
    }

    @Override
    public void deleteAdmin() {

    }

    @Override
    public ResponseEntity<?> findAllAdmins() {
        return null;
    }

//    Group

    @Override
    public ResponseEntity<?> createGroup(GroupPayload groupPayload) {

        try{
        Group group = new Group(
                groupPayload.getName(),
                groupPayload.getDepartment()
        );

        return ResponseEntity.ok(Result.ok(groupRepository.save(group), HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }

    }

    @Override
    public ResponseEntity<?> updateGroup(Long id,GroupPayload groupPayload) {

        try{
            Group group = new Group();
            group.setId(id);
            group.setName(groupPayload.getName());
            group.setDepartment(groupPayload.getDepartment());

            return ResponseEntity.ok(Result.ok(groupRepository.save(group), HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }
    }

    @Override
    public void deleteGroup(Long id) {

        try{
            groupRepository.deleteById(id);
        }catch (ResourceNotFoundException e){
            log.error("group id: "+id);
        }
    }

    @Override
    public ResponseEntity<?> findAllGroups() {

        try{
           return ResponseEntity.ok(Result.ok(groupRepository.findAll(),HttpStatus.OK.toString()));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.internalServerError().body(Result.error(e.getMessage()));

        }
    }

//    paymentToTrainingCenter

    @Override
    @Transactional
    public ResponseEntity<?> paymentToTrainingCenter(Long studentId, BigDecimal paidMeasure){

        try {
            Student student = studentRepository.findById(studentId).orElseThrow(()->new BadRequestException("not Found"));
            BigDecimal paid=student.getPayment().getPaidMeasure().add(paidMeasure),unpaid = student.getPayment().getUnpaidMeasure().subtract(paidMeasure);

            paymentRepository.insertPaymentToTrainingCenter(paid, unpaid, student.getPayment().getId());
            return  ResponseEntity.ok(Result.ok(paymentRepository.findCurrentlyAddedPayment(),HttpStatus.OK.toString()));
        }catch (BadRequestException e){
            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }

    }
//    paymentToTeacher

    @Override
    @Transactional
    public ResponseEntity<?> paymentToTeacher(Long teacherId, BigDecimal givenSalary){
        try{
            Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()->new BadRequestException("Not Found teacher"));
            BigDecimal given = teacher.getSalary().getGivenSalary().add(givenSalary),left = teacher.getSalary().getLeftSalary().subtract(givenSalary);

            salaryRepository.paymentToTeacher(given,left,teacher.getSalary().getId());

            return  ResponseEntity.ok(Result.ok(salaryRepository.findCurrentlyCreatedSalary(),HttpStatus.OK.toString()));
        }catch (BadRequestException e){

            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
        }
    }

}
