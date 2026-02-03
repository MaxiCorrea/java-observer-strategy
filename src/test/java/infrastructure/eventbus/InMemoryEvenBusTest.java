package infrastructure.eventbus;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.event.PaymentApprovedEvent;
import domain.model.Payment;

class InMemoryEvenBusTest {

	@Test
	@SuppressWarnings("unchecked")
	void shouldNotifyObservers() {
		InMemoryEvenBus bus = new InMemoryEvenBus();
		Consumer<PaymentApprovedEvent> consumer = Mockito.mock(Consumer.class);
		bus.register(PaymentApprovedEvent.class, consumer);
		Payment payment = new Payment("p-1");
		bus.publish(new PaymentApprovedEvent(payment));
		Mockito.verify(consumer).accept(Mockito.any(PaymentApprovedEvent.class));
	}

}
