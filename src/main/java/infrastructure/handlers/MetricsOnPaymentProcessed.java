package infrastructure.handlers;

import domain.event.PaymentApprovedEvent;

public class MetricsOnPaymentProcessed {

	public void handle(PaymentApprovedEvent event) {
		System.out.println("MetricsOnPaymentProcessed -> " + event.getPayment());
	}

}
