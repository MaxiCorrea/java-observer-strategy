package infrastructure.strategies;

import domain.model.Payment;
import domain.model.PaymentMethod;
import domain.model.PaymentStatus;
import domain.strategy.PaymentStrategy;

public class QrCodeStrategy implements PaymentStrategy {

	@Override
	public boolean supports(PaymentMethod method) {
		return method == PaymentMethod.QR_CODE;
	}

	@Override
	public PaymentStatus process(Payment payment) {
		payment.reject();
		return PaymentStatus.REJECTED;
	}

}
