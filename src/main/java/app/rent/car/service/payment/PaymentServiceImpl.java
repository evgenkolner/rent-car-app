package app.rent.car.service.payment;

import app.rent.car.dto.payment.CreatePaymentRequestDto;
import app.rent.car.dto.payment.PaymentDto;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentDto createPaymentSession(CreatePaymentRequestDto requestDto) {
        return null;
    }
}
