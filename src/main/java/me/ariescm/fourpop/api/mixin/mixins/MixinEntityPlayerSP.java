package me.ariescm.fourpop.api.mixin.mixins;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.ariescm.fourpop.api.event.events.EventPlayerUpdate;
import me.ariescm.fourpop.impl.Main;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

	public MixinEntityPlayerSP() {
		super(null, null);
	}
	   
	   @Inject(method = "onUpdate", at = @At("HEAD"), cancellable = true)
	    public void onUpdate(CallbackInfo info) {
	        EventPlayerUpdate event = new EventPlayerUpdate();
	        Main.EVENT_BUS.post(event);
	        if (event.isCancelled())
	            info.cancel();
	    }
}
