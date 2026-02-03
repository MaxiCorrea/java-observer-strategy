package domain.event;

import domain.model.Payment;

public class PaymentRejectedEvent implements DomainEvent {

	private final Payment payment;
	private final String cause;
	
	public PaymentRejectedEvent(
			final Payment payment,
			final String cause) {
		this.payment = payment;
		this.cause = cause;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public String getCause() {
		return cause;
	}
	
}
