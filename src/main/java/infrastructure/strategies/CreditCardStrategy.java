package infrastructure.strategies;

import domain.model.Payment;
import domain.model.PaymentMethod;
import domain.model.PaymentStatus;
import domain.strategy.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

	@Override
	public boolean supports(
			final PaymentMethod method) {
		return method == PaymentMethod.CREDIT_CARD;
	}

	@Override
	public PaymentStatus process(
			final Payment payment) {
		payment.approved();
		return PaymentStatus.APPROVED;
	}

}
