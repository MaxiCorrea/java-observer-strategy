package application.usecase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import application.eventbus.EventBus;
import domain.event.DomainEvent;
import domain.model.Payment;
import domain.model.PaymentMethod;
import domain.model.PaymentStatus;
import infrastructure.strategies.CreditCardStrategy;

class ProcessPaymentUseCaseTest {

	@Test
	void publishEventAfterProcessing() {
		Payment payment = new Payment("pay-1");
		FakeEventBus bus = new FakeEventBus();
		ProcessPaymentUseCase usecase = new ProcessPaymentUseCase(List.of(new CreditCardStrategy()), bus);
		usecase.execute(payment, PaymentMethod.CREDIT_CARD);
		assertEquals(PaymentStatus.APPROVED, payment.getStatus());
		assertEquals(1, bus.publishedEvents);
	}

	private class FakeEventBus implements EventBus {

		int publishedEvents = 0;
		
		@Override
		public void publish(DomainEvent event) {
			++publishedEvents;
		}
		
	}
	
}
