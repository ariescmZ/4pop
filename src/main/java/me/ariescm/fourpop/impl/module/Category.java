package me.ariescm.fourpop.impl.module;

public enum Category {
	PLAYER("Player"), RENDER("Render"), COMBAT("Combat"), EXPLOITS("Exploits"), MOVEMENT("Movement"), CLIENT("Client"), HUD("HUD");
	
	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}

}

