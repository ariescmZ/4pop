package me.ariescm.fourpop.api.event.events;

import me.ariescm.fourpop.api.event.Event;

public class EventPlayerJoin extends Event {

	private final String name;

	public EventPlayerJoin(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}