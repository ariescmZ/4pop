package me.ariescm.fourpop.api.event.events;

import me.ariescm.fourpop.api.event.Event;

public class EventPlayerLeave extends Event {

	private final String name;

	public EventPlayerLeave(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}