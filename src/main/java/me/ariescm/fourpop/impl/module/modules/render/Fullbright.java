package me.ariescm.fourpop.impl.module.modules.render;

import org.lwjgl.input.Keyboard;

import me.ariescm.fourpop.api.event.events.EventPlayerUpdate;
import me.ariescm.fourpop.impl.Main;
import me.ariescm.fourpop.impl.module.Category;
import me.ariescm.fourpop.impl.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.init.MobEffects;

public class Fullbright extends Module {
	
	public Fullbright() {
		super("ExampleFullBright", "makes ur game fully bright", Keyboard.KEY_U, Category.RENDER);
	}
	private float lastGamma;

	 @Override
	 public void onEnable() {
	     super.onEnable();
	     Main.EVENT_BUS.subscribe(this);
	        
	     lastGamma = mc.gameSettings.gammaSetting;
	 }

	 @Override
	 public void onDisable() {
	     super.onDisable();
	     Main.EVENT_BUS.unsubscribe(this);
	           
	     mc.gameSettings.gammaSetting = this.lastGamma;
	 }

	 @EventHandler
	 private Listener<EventPlayerUpdate> OnPlayerUpdate = new Listener<>(p_Event -> {
	     mc.gameSettings.gammaSetting = 1000;
        mc.player.removePotionEffect(MobEffects.NIGHT_VISION);
	 });

}
