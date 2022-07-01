package uz.zako.trainingmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.zako.trainingmanagementsystem.entity.payment.Payment;
import uz.zako.trainingmanagementsystem.payload.paymentPayload.PaymentPayload;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentPayload, Payment>{

    @Override
    @Mapping(source = "payment",target = "payment")
    @Mapping(source = "paidMeasure",target = "paidMeasure")
    @Mapping(source = "unpaidMeasure",target = "unpaidMeasure")
    @Mapping(source = "paymentType",target = "paymentType")
    @Mapping(source = "students",target = "studentPayloads")
    PaymentPayload toDto(Payment payment);

    @Override
    @Mapping(source = "payment",target = "payment")
    @Mapping(source = "paidMeasure",target = "paidMeasure")
    @Mapping(source = "unpaidMeasure",target = "unpaidMeasure")
    @Mapping(source = "paymentType",target = "paymentType")
    @Mapping(source = "studentPayloads",target = "students")
    List<PaymentPayload> toDto(List<Payment> e);
}
