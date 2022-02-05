package me.ariescm.fourpop.impl.module.modules.client;

import org.lwjgl.input.Keyboard;

import me.ariescm.fourpop.api.utils.Discord;
import me.ariescm.fourpop.impl.module.Category;
import me.ariescm.fourpop.impl.module.Module;

public class DiscordRPC extends Module {

	public DiscordRPC() {
		super("DiscordRPC", "shows 4pop trollage activities in discord", Keyboard.KEY_NONE, Category.CLIENT);
	}
	
	@Override
	public void onEnable() {
	    Discord.startRPC();
	}
	
	@Override
	public void onDisable() {
	    Discord.stopRPC();
	}
}
