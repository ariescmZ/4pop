package me.ariescm.fourpop.impl.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.ariescm.fourpop.impl.module.Category;
import me.ariescm.fourpop.impl.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "automatically sprints when u move forward.", Keyboard.KEY_R, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(mc.player.movementInput.moveForward > 0 && !mc.player.isSneaking() && !mc.player.collidedHorizontally) {
			mc.player.setSprinting(true);
		}
	}
}