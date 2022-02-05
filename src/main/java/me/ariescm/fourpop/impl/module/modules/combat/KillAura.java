package me.ariescm.fourpop.impl.module.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import me.ariescm.fourpop.impl.module.Category;
import me.ariescm.fourpop.impl.module.Module;
import me.ariescm.fourpop.impl.setting.settings.BooleanSetting;
import me.ariescm.fourpop.impl.setting.settings.NumberSetting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KillAura extends Module {
	public NumberSetting rangeA = new NumberSetting("range", this, 4, 1, 6, 0.5);
	public BooleanSetting passiveMobsA = new BooleanSetting("passives", this, false);
	public BooleanSetting hostileMobsA = new BooleanSetting("hostiles", this, false);
	public BooleanSetting playersA = new BooleanSetting("players", this, true);
	
	public KillAura() {
		super ("ExampleKillAura", "automatically hits anything near u", Keyboard.KEY_Y, Category.COMBAT);
		this.addSetting(rangeA, playersA, passiveMobsA, hostileMobsA);
	}

	public void onUpdate() {
		if (mc.player == null || mc.player.isDead) return;
		List<Entity> targets = mc.world.loadedEntityList.stream()
				.filter(entity -> entity != mc.player)
				.filter(entity -> mc.player.getDistance(entity) <= rangeA.getValue())
				.filter(entity -> !entity.isDead)
				.filter(entity -> attackCheck(entity))
				.sorted(Comparator.comparing(s -> mc.player.getDistance(s)))
				.collect(Collectors.toList());

		targets.forEach(target -> {
			attack(target);
		});
	}
	

	public void onEnable() {
		super.onEnable();
	}

	public void onDisable() {
		super.onDisable();
	}

	public void attack(Entity e) {
		if (mc.player.getCooledAttackStrength(0) >= 1){
			mc.playerController.attackEntity(mc.player, e);
			mc.player.swingArm(EnumHand.MAIN_HAND);
		}
	}
	
	private boolean attackCheck(Entity entity) {

		if (playersA.isEnabled() && entity instanceof EntityPlayer){
			if (((EntityPlayer) entity).getHealth() > 0) {
				return true;
			}
		}

		if (passiveMobsA.isEnabled() && entity instanceof EntityAnimal) {
			if (entity instanceof EntityTameable) {
				return false;
			}
			else {
				return true;
			}
		}
		if (hostileMobsA.isEnabled() && entity instanceof EntityMob) {
			return true;
		}
		return false;
	}
}
