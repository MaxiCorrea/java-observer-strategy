package application.eventbus;

import domain.event.DomainEvent;

public interface EventBus {
	
	void publish(DomainEvent event);

}
