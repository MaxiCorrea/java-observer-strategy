package infrastructure.handlers;

import domain.event.PaymentApprovedEvent;

public class EmailOnPaymentProcessed {

	public void handle(PaymentApprovedEvent event) {
		System.out.println("EmailOnPaymentProcessed -> " + event.getPayment());
	}
	
}
