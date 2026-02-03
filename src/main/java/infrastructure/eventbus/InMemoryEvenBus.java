package infrastructure.eventbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import application.eventbus.EventBus;
import domain.event.DomainEvent;

public class InMemoryEvenBus implements EventBus {

	private final Map<Class<?>, List<Consumer<DomainEvent>>> handlers;
	
	public InMemoryEvenBus() {
		handlers = new HashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends DomainEvent> void register(
			final Class<T> eventType,
			Consumer<T> handler) {
		handlers.computeIfAbsent(eventType, k -> new ArrayList<>())
			.add((Consumer<DomainEvent>) handler);
	}
	
	@Override
	public void publish(
			final DomainEvent event) {
		this.handlers.getOrDefault(event.getClass(), List.of())
			.forEach(e -> e.accept(event));
	}

}
