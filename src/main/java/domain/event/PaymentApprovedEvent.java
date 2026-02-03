package domain.event;

import domain.model.Payment;

public class PaymentApprovedEvent implements DomainEvent {

	private final Payment payment;
	
	public PaymentApprovedEvent(
			final Payment payment) {
		this.payment = payment;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
}
