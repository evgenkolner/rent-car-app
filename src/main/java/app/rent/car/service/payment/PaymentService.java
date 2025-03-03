package app.rent.car.service.payment;

import app.rent.car.dto.payment.CreatePaymentRequestDto;
import app.rent.car.dto.payment.PaymentDto;

public interface PaymentService {
    PaymentDto createPaymentSession(CreatePaymentRequestDto requestDto);
}
