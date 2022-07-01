package uz.zako.trainingmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.zako.trainingmanagementsystem.entity.Student;

import uz.zako.trainingmanagementsystem.payload.StudentPayload;


import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentPayload, Student> {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    @Mapping(target = "age",source = "age")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "group.id",source = "groupId")
    @Mapping(target = "payment.payment",source = "paymentPayload.payment")
    @Mapping(target = "payment.paidMeasure",source = "paymentPayload.paidMeasure")
    @Mapping(target = "payment.unpaidMeasure",source = "paymentPayload.unpaidMeasure")
    @Mapping(target = "payment.paymentType",source = "paymentPayload.paymentType")
    Student toEntity(StudentPayload studentPayload);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    @Mapping(target = "age",source = "age")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "paymentPayload.payment",source = "payment.payment")
    @Mapping(target = "paymentPayload.paidMeasure",source = "payment.paidMeasure")
    @Mapping(target = "paymentPayload.unpaidMeasure",source = "payment.unpaidMeasure")
    @Mapping(target = "paymentPayload.paymentType",source = "payment.paymentType")
    StudentPayload toDto(Student student);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    @Mapping(target = "age",source = "age")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "payment.payment",source = "paymentPayload.payment")
    @Mapping(target = "payment.paidMeasure",source = "paymentPayload.paidMeasure")
    @Mapping(target = "payment.unpaidMeasure",source = "paymentPayload.unpaidMeasure")
    @Mapping(target = "payment.paymentType",source = "paymentPayload.paymentType")
    List<Student> toEntity(List<StudentPayload> d);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    @Mapping(target = "age",source = "age")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "paymentPayload.payment",source = "payment.payment")
    @Mapping(target = "paymentPayload.paidMeasure",source = "payment.paidMeasure")
    @Mapping(target = "paymentPayload.unpaidMeasure",source = "payment.unpaidMeasure")
    @Mapping(target = "paymentPayload.paymentType",source = "payment.paymentType")
    List<StudentPayload> toDto(List<Student> students);
}
