package domain.strategy;

import domain.model.Payment;
import domain.model.PaymentMethod;
import domain.model.PaymentStatus;

public interface PaymentStrategy {

	boolean supports(PaymentMethod method);
	
	PaymentStatus process(Payment payment);
}
