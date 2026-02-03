package application.usecase;

import java.util.List;

import application.eventbus.EventBus;
import domain.event.PaymentApprovedEvent;
import domain.event.PaymentRejectedEvent;
import domain.model.Payment;
import domain.model.PaymentMethod;
import domain.model.PaymentStatus;
import domain.strategy.PaymentStrategy;

public class ProcessPaymentUseCase {

	private final List<PaymentStrategy> strategies;
	private final EventBus eventBus;
	
	public ProcessPaymentUseCase(
			final List<PaymentStrategy> strategies,
			final EventBus eventBus) {
		this.strategies = List.copyOf(strategies);
		this.eventBus = eventBus;
	}
	
	public void execute(
			final Payment payment,
			final PaymentMethod method) {
		
		PaymentStrategy strategy = strategies.stream()
				.filter(e -> e.supports(method))
				.findFirst().orElseThrow();
		
		PaymentStatus status = strategy.process(payment);
		if(status == PaymentStatus.APPROVED)
			 eventBus.publish(new PaymentApprovedEvent(payment));
		if(status == PaymentStatus.REJECTED)
			eventBus.publish(new PaymentRejectedEvent(payment, "Insufficient funds"));
	}
	
}
